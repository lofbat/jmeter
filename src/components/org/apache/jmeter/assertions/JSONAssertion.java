package org.apache.jmeter.assertions;

import com.google.gson.Gson;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testelement.AbstractTestElement;
import org.apache.jmeter.testelement.ThreadListener;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

import java.io.Serializable;

public class JSONAssertion extends AbstractTestElement implements Serializable, Assertion, ThreadListener {
    private static final Logger log = LoggingManager.getLoggerForClass();

    private static final long serialVersionUID = 240L;

    /**
     * Returns the result of the Assertion. Here it checks wether the Sample
     * took to long to be considered successful. If so an AssertionResult
     * containing a FailureMessage will be returned. Otherwise the returned
     * AssertionResult will reflect the success of the Sample.
     */
    @Override
    public AssertionResult getResult(SampleResult response) {
        // no error as default
        AssertionResult result = new AssertionResult(getName());
        String resultData = response.getResponseDataAsString();

        if (resultData.length()==0) {
            return result.setResultForNull();
        }else{
            Gson gson = new Gson();
            if(!gson.toJsonTree(resultData).isJsonObject()){
                log.debug("Cannot parse result content"); // may well happen
                result.setFailure(true);
                result.setFailureMessage("ResultData is not Json");
            }
        }
        return result;

    }

    @Override
    public void threadStarted() {
    }

    @Override
    public void threadFinished() {
    }
}

