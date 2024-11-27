package com.vs.logging;

import com.epam.reportportal.listeners.ListenerParameters;
import com.epam.reportportal.service.Launch;
import com.epam.reportportal.service.ReportPortal;
import com.epam.reportportal.testng.TestNGService;
import com.epam.reportportal.utils.properties.PropertiesLoader;
import com.epam.ta.reportportal.ws.model.attribute.ItemAttributesRQ;
import com.epam.ta.reportportal.ws.model.launch.StartLaunchRQ;
import io.opentelemetry.api.internal.StringUtils;

import javax.validation.ReportAsSingleViolation;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;

public class ParamOverrideTestNgService extends TestNGService {
    public ParamOverrideTestNgService() {
        super(getLaunchOverriddenProperties());
    }

    private static Supplier<Launch> getLaunchOverriddenProperties() {
        ListenerParameters parameters = new ListenerParameters(PropertiesLoader.load());
        Set<ItemAttributesRQ> attributes = new HashSet<>();
        attributes.add(new ItemAttributesRQ("group","test"));
        parameters.setAttributes(attributes);
        ReportPortal reportPortal = ReportPortal.builder().withParameters(parameters).build();
        StartLaunchRQ rq = buildStartLaunch(reportPortal.getParameters());
        return () -> reportPortal.newLaunch(rq);
    }

    private static StartLaunchRQ buildStartLaunch(ListenerParameters parameters) {
        System.out.println(parameters);
        StartLaunchRQ rq = new StartLaunchRQ();
        rq.setName(parameters.getLaunchName());
        rq.setStartTime(Calendar.getInstance().getTime());
        rq.setAttributes(parameters.getAttributes());
        rq.setMode(parameters.getLaunchRunningMode());
        if (!StringUtils.isNullOrEmpty(parameters.getDescription())) {
            rq.setDescription(parameters.getDescription());
        }
        return rq;
    }
}
