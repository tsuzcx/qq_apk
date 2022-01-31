package android.support.v4.print;

import android.content.Context;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;
import android.support.annotation.RequiresApi;

@RequiresApi(23)
class PrintHelper$PrintHelperApi23
  extends PrintHelper.PrintHelperApi20
{
  PrintHelper$PrintHelperApi23(Context paramContext)
  {
    super(paramContext);
    this.mIsMinMarginsHandlingCorrect = false;
  }
  
  protected PrintAttributes.Builder copyAttributes(PrintAttributes paramPrintAttributes)
  {
    PrintAttributes.Builder localBuilder = super.copyAttributes(paramPrintAttributes);
    if (paramPrintAttributes.getDuplexMode() != 0) {
      localBuilder.setDuplexMode(paramPrintAttributes.getDuplexMode());
    }
    return localBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.print.PrintHelper.PrintHelperApi23
 * JD-Core Version:    0.7.0.1
 */