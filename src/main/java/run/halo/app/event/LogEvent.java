package run.halo.app.event;

import org.springframework.context.ApplicationEvent;
import run.halo.app.model.enums.LogType;
import run.halo.app.model.params.LogParam;
import run.halo.app.utils.ValidationUtils;

/**
 * @author johnniang
 * @date 19-4-20
 */
public class LogEvent extends ApplicationEvent {

    private final LogParam logParam;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source   the object on which the event initially occurred (never {@code null})
     * @param logParam
     */
    public LogEvent(Object source, LogParam logParam) {
        super(source);

        // Validate the log param
        ValidationUtils.validate(logParam);

        this.logParam = logParam;
    }

    public LogEvent(Object source, String logKey, LogType logType, String content) {
        this(source, new LogParam(logKey, logType, content));
    }

    public LogParam getLogParam() {
        return logParam;
    }
}
