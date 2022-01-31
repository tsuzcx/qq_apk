package tmsdk.common.module.pgsdk;

import java.util.ArrayList;

public abstract interface PreviewCallback
{
  public abstract void onDismissPreview();
  
  @Deprecated
  public abstract void onShowPreviewAnimation(int[] paramArrayOfInt, int paramInt1, int paramInt2, PageNextCallback paramPageNextCallback, ConfirmCallback paramConfirmCallback);
  
  public abstract void onShowPreviewDoraemon(int[] paramArrayOfInt, int paramInt, boolean paramBoolean, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, PageNextCallback paramPageNextCallback, ConfirmCallback paramConfirmCallback);
  
  public abstract void onShowPreviewImage(int[] paramArrayOfInt, int paramInt, ArrayList paramArrayList1, ArrayList paramArrayList2, PageNextCallback paramPageNextCallback, ConfirmCallback paramConfirmCallback);
  
  public abstract void onShowPreviewImageText(int[] paramArrayOfInt, int paramInt, boolean paramBoolean, ArrayList paramArrayList1, ArrayList paramArrayList2, PageNextCallback paramPageNextCallback, ConfirmCallback paramConfirmCallback);
  
  public abstract void onShowPreviewText(int[] paramArrayOfInt, int paramInt, String paramString, PageNextCallback paramPageNextCallback, ConfirmCallback paramConfirmCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.PreviewCallback
 * JD-Core Version:    0.7.0.1
 */