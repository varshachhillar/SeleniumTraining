package testngpractise;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class executionretry implements IAnnotationTransformer {
    public void transform(ITestAnnotation ita, Class tc, Constructor tcon, Method tmeMethod){
        ita.setRetryAnalyzer(fixedretry.class);
    }

}
