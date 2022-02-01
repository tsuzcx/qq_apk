import dov.com.qq.im.capture.mode.CaptureModeController;

public abstract class aycl
  extends axqo
{
  protected awsy a;
  public boolean avm;
  protected boolean dyn;
  protected boolean dyo;
  
  public aycl(CaptureModeController paramCaptureModeController)
  {
    super(paramCaptureModeController);
    this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController = paramCaptureModeController;
    this.jdField_b_of_type_Awrq = this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.jdField_b_of_type_Awrq;
    if ((this.jdField_b_of_type_Awrq instanceof awsy)) {
      this.a = ((awsy)this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.jdField_b_of_type_Awrq);
    }
  }
  
  public int PQ()
  {
    return this.modeType;
  }
  
  protected void YQ(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      uz(this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.dwg);
      return;
    }
    shutdown();
  }
  
  public void onActivityDestroy()
  {
    this.avm = true;
    this.dyn = false;
  }
  
  public void onActivityResume() {}
  
  public void onActivityStop() {}
  
  public void shutdown()
  {
    this.dyn = false;
  }
  
  public void uz(boolean paramBoolean)
  {
    this.dyn = true;
    this.avm = false;
    this.dyo = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aycl
 * JD-Core Version:    0.7.0.1
 */