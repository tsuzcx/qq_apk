import android.content.Context;
import android.view.SurfaceHolder;

public class awld
{
  private Object gj = awcj.creatSpecifiedObject("com.tencent.tar.TarInterface", null, new Object[0]);
  
  public int Qn()
  {
    Object localObject = awcj.callSpecifiedMethod(this.gj, "getConfigWith", false, null, new Object[0]);
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    return -1;
  }
  
  public int Qo()
  {
    Object localObject = awcj.callSpecifiedMethod(this.gj, "getConfigHeight", false, null, new Object[0]);
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    return -1;
  }
  
  public void X(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    awcj.callSpecifiedMethod(this.gj, "onSurfaceChanged", false, getParamsClass(new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
  }
  
  public int a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean)
  {
    paramSurfaceHolder = awcj.callSpecifiedMethod(this.gj, "onDrawFrame", false, getParamsClass(new Class[] { SurfaceHolder.class, Boolean.TYPE }), new Object[] { paramSurfaceHolder, Boolean.valueOf(paramBoolean) });
    if ((paramSurfaceHolder instanceof Integer)) {
      return ((Integer)paramSurfaceHolder).intValue();
    }
    return 0;
  }
  
  public void ad(float paramFloat1, float paramFloat2)
  {
    awcj.callSpecifiedMethod(this.gj, "setTrackingPoint", false, getParamsClass(new Class[] { Float.TYPE, Float.TYPE }), new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
  }
  
  public void akO()
  {
    awcj.callSpecifiedMethod(this.gj, "onSurfaceCreated", false, null, new Object[0]);
  }
  
  public Class[] getParamsClass(Class... paramVarArgs)
  {
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfClass[i] = paramVarArgs[i];
      i += 1;
    }
    return arrayOfClass;
  }
  
  public float[] i()
  {
    Object localObject = awcj.callSpecifiedMethod(this.gj, "getModelMatrix", false, null, new Object[0]);
    if ((localObject instanceof float[])) {
      return (float[])localObject;
    }
    return null;
  }
  
  public void init(Context paramContext, int paramInt)
  {
    awcj.callSpecifiedMethod(this.gj, "init", false, getParamsClass(new Class[] { Context.class, Integer.TYPE }), new Object[] { paramContext, Integer.valueOf(paramInt) });
  }
  
  public float[] j()
  {
    Object localObject = awcj.callSpecifiedMethod(this.gj, "getViewMatrix", false, null, new Object[0]);
    if ((localObject instanceof float[])) {
      return (float[])localObject;
    }
    return null;
  }
  
  public float[] k()
  {
    Object localObject = awcj.callSpecifiedMethod(this.gj, "getProjectionMatrix", false, null, new Object[0]);
    if ((localObject instanceof float[])) {
      return (float[])localObject;
    }
    return null;
  }
  
  public float[] l()
  {
    Object localObject = awcj.callSpecifiedMethod(this.gj, "getScaleMatrix", false, null, new Object[0]);
    if ((localObject instanceof float[])) {
      return (float[])localObject;
    }
    return null;
  }
  
  public void onDestroy()
  {
    awcj.callSpecifiedMethod(this.gj, "onDestroy", false, null, new Object[0]);
  }
  
  public void onResume()
  {
    awcj.callSpecifiedMethod(this.gj, "onResume", false, null, new Object[0]);
  }
  
  public void onStop()
  {
    awcj.callSpecifiedMethod(this.gj, "onStop", false, null, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awld
 * JD-Core Version:    0.7.0.1
 */