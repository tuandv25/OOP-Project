package hust.soict.globalict.entity;

import javax.swing.JPanel;

import hust.soict.globalict.algorithms.PointRun;

public class ElementBoxs {
	protected int num;
    protected JPanel pnImitiate;
    protected ElementBox[] elementBoxs;

    public void setPnImitiate(JPanel pnImitiate) {
        this.pnImitiate = pnImitiate;
    }

    public void setElementBoxs(ElementBox[] elementBoxs) {
        this.elementBoxs = elementBoxs;
    }

    public ElementBox[] getElementBoxs() {
        return elementBoxs;
    }

    public ElementBoxs(JPanel pnImitiate, int num, ElementBox[] elementBoxs, PointRun pointRun, int yLocation) {
        setPnImitiate(pnImitiate);
        elementBoxs = new ElementBox[num];

        for (int i = 0; i < num; i++) {
            elementBoxs[i] = new ElementBox();
            pnImitiate.add(elementBoxs[i].getLabel());
            int value = elementBoxs[i].getValue();
            elementBoxs[i].getLabel().setText(String.valueOf(value));
            elementBoxs[i].setValue(value);
            // set location label
            if (i == 0)
                elementBoxs[i].getLabel().setLocation((16 - num) * 35, yLocation);
            else
                elementBoxs[i].getLabel().setLocation(elementBoxs[i - 1].getLabel().getX() + 70, yLocation);
        }
        setElementBoxs(elementBoxs);
        pnImitiate.add(pointRun.getLbPoint1());
        pnImitiate.add(pointRun.getLbPoint2());
        pnImitiate.add(pointRun.getLbPointM());

        pnImitiate.setVisible(true);
        pnImitiate.validate();
        pnImitiate.repaint();
    }

    
 
}
