package android.support.v8.renderscript;

public class ScriptIntrinsicYuvToRGBThunker
  extends ScriptIntrinsicYuvToRGB
{
  android.renderscript.ScriptIntrinsicYuvToRGB mN;
  
  private ScriptIntrinsicYuvToRGBThunker(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  public static ScriptIntrinsicYuvToRGBThunker create(RenderScript paramRenderScript, Element paramElement)
  {
    RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
    paramElement = (ElementThunker)paramElement;
    paramRenderScript = new ScriptIntrinsicYuvToRGBThunker(0, paramRenderScript);
    paramRenderScript.mN = android.renderscript.ScriptIntrinsicYuvToRGB.create(localRenderScriptThunker.mN, paramElement.getNObj());
    return paramRenderScript;
  }
  
  public void forEach(Allocation paramAllocation)
  {
    paramAllocation = (AllocationThunker)paramAllocation;
    this.mN.setInput(paramAllocation.getNObj());
  }
  
  public Script.FieldID getFieldID_Input()
  {
    Script.FieldID localFieldID = createFieldID(0, null);
    localFieldID.mN = this.mN.getFieldID_Input();
    return localFieldID;
  }
  
  public Script.KernelID getKernelID()
  {
    Script.KernelID localKernelID = createKernelID(0, 2, null, null);
    localKernelID.mN = this.mN.getKernelID();
    return localKernelID;
  }
  
  android.renderscript.ScriptIntrinsicYuvToRGB getNObj()
  {
    return this.mN;
  }
  
  public void setInput(Allocation paramAllocation)
  {
    paramAllocation = (AllocationThunker)paramAllocation;
    this.mN.setInput(paramAllocation.getNObj());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptIntrinsicYuvToRGBThunker
 * JD-Core Version:    0.7.0.1
 */