package tmsdk.common.module.pgsdk;

import java.util.ArrayList;

public abstract interface PageCallback
{
  @Deprecated
  public abstract void onShowAnimation(int[] paramArrayOfInt, int paramInt1, int paramInt2, boolean paramBoolean, PageNextCallback paramPageNextCallback, ConfirmCallback paramConfirmCallback);
  
  public abstract void onShowDoraemon(int[] paramArrayOfInt, int paramInt, boolean paramBoolean1, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, boolean paramBoolean2, PageNextCallback paramPageNextCallback, ConfirmCallback paramConfirmCallback);
  
  public abstract void onShowImage(int[] paramArrayOfInt, int paramInt, ArrayList paramArrayList1, ArrayList paramArrayList2, boolean paramBoolean, PageNextCallback paramPageNextCallback, ConfirmCallback paramConfirmCallback);
  
  public abstract void onShowImageText(int[] paramArrayOfInt, int paramInt, boolean paramBoolean1, ArrayList paramArrayList1, ArrayList paramArrayList2, boolean paramBoolean2, PageNextCallback paramPageNextCallback, ConfirmCallback paramConfirmCallback);
  
  public abstract void onShowText(int[] paramArrayOfInt, int paramInt, String paramString, boolean paramBoolean, PageNextCallback paramPageNextCallback, ConfirmCallback paramConfirmCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.PageCallback
 * JD-Core Version:    0.7.0.1
 */