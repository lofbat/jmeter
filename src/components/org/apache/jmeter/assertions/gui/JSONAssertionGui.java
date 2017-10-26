package org.apache.jmeter.assertions.gui;

import org.apache.jmeter.assertions.JSONAssertion;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jorphan.gui.layout.VerticalLayout;

public class JSONAssertionGui extends AbstractAssertionGui {

    private static final long serialVersionUID = 240L;

    /**
     * The constructor.
     */
    public JSONAssertionGui() {
        init();
    }

    /**
     * Returns the label to be shown within the JTree-Component.
     */
    @Override
    public String getLabelResource() {
        return "json_assertion_title"; // $NON-NLS-1$
    }

    @Override
    public TestElement createTestElement() {
        JSONAssertion e = new JSONAssertion();
        modifyTestElement(e);
        return e;
    }

    /**
     * Modifies a given TestElement to mirror the data in the gui components.
     *
     * @see org.apache.jmeter.gui.JMeterGUIComponent#modifyTestElement(TestElement)
     */
    @Override
    public void modifyTestElement(TestElement el) {
        configureTestElement(el);
    }

    /**
     * Inits the GUI.
     */
    private void init() {
        setLayout(new VerticalLayout(5, VerticalLayout.BOTH, VerticalLayout.TOP));
        setBorder(makeBorder());

        add(makeTitlePanel());
    }
}
