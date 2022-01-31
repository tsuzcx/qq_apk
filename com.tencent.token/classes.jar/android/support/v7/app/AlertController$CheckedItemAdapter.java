package android.support.v7.app;

import android.content.Context;
import android.widget.ArrayAdapter;

class AlertController$CheckedItemAdapter
  extends ArrayAdapter
{
  public AlertController$CheckedItemAdapter(Context paramContext, int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence)
  {
    super(paramContext, paramInt1, paramInt2, paramArrayOfCharSequence);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AlertController.CheckedItemAdapter
 * JD-Core Version:    0.7.0.1
 */