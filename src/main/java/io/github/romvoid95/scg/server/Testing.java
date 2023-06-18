package io.github.romvoid95.scg.server;

import java.lang.reflect.Field;
import java.util.TimeZone;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.Nullable;
import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.DateBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.google.common.base.Preconditions;

public class Testing
{
    private final TimeZone UTC = TimeZone.getTimeZone("UTC");
    private final int THURSDAY = DateBuilder.THURSDAY;
    private final CronScheduleBuilder SCHEDULE = CronScheduleBuilder.weeklyOnDayAndHourAndMinute(THURSDAY, 7, 0).inTimeZone(UTC);
    
    public static void main(String[] args) throws Exception
    {
        new EventServer();
    }
    
    public Testing() throws Exception
    {
        CronExpression cronExp = getPrivateValue(CronScheduleBuilder.class, SCHEDULE, "cronExpression");
        
        System.out.println(cronExp.getCronExpression());
        System.out.println(cronExp.getExpressionSummary());
        
        JobDetail job1       = JobBuilder.newJob(J1.class).withIdentity("o7", "group1").build();
        TriggerBuilder<Trigger>   trigger1   = TriggerBuilder.newTrigger().withIdentity("PurgeGearPosts");
        Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
        scheduler1.start();
        scheduler1.scheduleJob(job1, trigger1.build());
    }
    
    @SuppressWarnings("unchecked")
    public static <T, E> T getPrivateValue(Class<? super E> classToAccess, @Nullable E instance, String fieldName) {
        try {
            return (T) findField(classToAccess, fieldName, null).get(instance);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
    
    public static Field findField(@Nonnull Class<?> clazz, @Nonnull String fieldName, @Nullable String fieldObfName) {
        Preconditions.checkNotNull(clazz);
        try {
            Field f = clazz.getDeclaredField(fieldName);
            f.setAccessible(true);
            return f;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    static class J1 implements Job
    {

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException
        {
        }

    }
}
