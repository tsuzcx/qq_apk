package android.support.v8.renderscript;

class ScriptIntrinsicLUTThunker
  extends ScriptIntrinsicLUT
{
  android.renderscript.ScriptIntrinsicLUT mN;
  
  private ScriptIntrinsicLUTThunker(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  public static ScriptIntrinsicLUTThunker create(RenderScript paramRenderScript, Element paramElement)
  {
    RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
    paramElement = (ElementThunker)paramElement;
    paramRenderScript = new ScriptIntrinsicLUTThunker(0, paramRenderScript);
    paramRenderScript.mN = android.renderscript.ScriptIntrinsicLUT.create(localRenderScriptThunker.mN, paramElement.getNObj());
    return paramRenderScript;
  }
  
  public void forEach(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    paramAllocation1 = (AllocationThunker)paramAllocation1;
    paramAllocation2 = (AllocationThunker)paramAllocation2;
    this.mN.forEach(paramAllocation1.getNObj(), paramAllocation2.getNObj());
  }
  
  public Script.KernelID getKernelID()
  {
    Script.KernelID localKernelID = createKernelID(0, 3, null, null);
    localKernelID.mN = this.mN.getKernelID();
    return localKernelID;
  }
  
  android.renderscript.ScriptIntrinsicLUT getNObj()
  {
    return this.mN;
  }
  
  public void setAlpha(int paramInt1, int paramInt2)
  {
    this.mN.setAlpha(paramInt1, paramInt2);
  }
  
  public void setBlue(int paramInt1, int paramInt2)
  {
    this.mN.setBlue(paramInt1, paramInt2);
  }
  
  public void setGreen(int paramInt1, int paramInt2)
  {
    this.mN.setGreen(paramInt1, paramInt2);
  }
  
  public void setRed(int paramInt1, int paramInt2)
  {
    this.mN.setRed(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptIntrinsicLUTThunker
 * JD-Core Version:    0.7.0.1
 */