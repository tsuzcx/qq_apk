import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ahzu
{
  @TargetApi(17)
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, Context paramContext)
  {
    paramContext = RenderScript.create(paramContext);
    Allocation localAllocation1 = Allocation.createFromBitmap(paramContext, paramBitmap);
    Allocation localAllocation2 = Allocation.createTyped(paramContext, localAllocation1.getType());
    ScriptIntrinsicBlur localScriptIntrinsicBlur = ScriptIntrinsicBlur.create(paramContext, Element.U8_4(paramContext));
    localScriptIntrinsicBlur.setRadius(paramFloat);
    localScriptIntrinsicBlur.setInput(localAllocation1);
    localScriptIntrinsicBlur.forEach(localAllocation2);
    localAllocation2.copyTo(paramBitmap);
    localAllocation1.destroy();
    localAllocation2.destroy();
    localScriptIntrinsicBlur.destroy();
    paramContext.destroy();
    return paramBitmap;
  }
  
  public static List<File> c(File paramFile)
  {
    LinkedList localLinkedList = new LinkedList();
    File[] arrayOfFile = paramFile.listFiles();
    paramFile = localLinkedList;
    if (arrayOfFile != null)
    {
      paramFile = Arrays.asList(arrayOfFile);
      Collections.sort(paramFile, new ahzu.a(null));
    }
    return paramFile;
  }
  
  static final class a
    implements Comparator<File>
  {
    private int compareLong(long paramLong1, long paramLong2)
    {
      if (paramLong1 < paramLong2) {
        return -1;
      }
      if (paramLong1 == paramLong2) {
        return 0;
      }
      return 1;
    }
    
    public int compare(File paramFile1, File paramFile2)
    {
      return compareLong(paramFile1.lastModified(), paramFile2.lastModified());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahzu
 * JD-Core Version:    0.7.0.1
 */