package tmsdk.common.module.pgsdk;

import java.util.ArrayList;

public abstract interface WindowCallback
{
  public abstract void onDismissWindow();
  
  @Deprecated
  public abstract void onShowAnimation(int[] paramArrayOfInt, int paramInt1, boolean paramBoolean, int paramInt2, ConfirmCallback paramConfirmCallback);
  
  public abstract void onShowDoraemon(int[] paramArrayOfInt, int paramInt, boolean paramBoolean1, boolean paramBoolean2, ArrayList<String> paramArrayList, ArrayList<Integer> paramArrayList1, ArrayList<ArrayList<String>> paramArrayList2, ConfirmCallback paramConfirmCallback);
  
  public abstract void onShowImage(int[] paramArrayOfInt, int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ConfirmCallback paramConfirmCallback);
  
  public abstract void onShowImageText(int[] paramArrayOfInt, int paramInt, boolean paramBoolean1, boolean paramBoolean2, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ConfirmCallback paramConfirmCallback);
  
  public abstract void onShowText(int[] paramArrayOfInt, int paramInt, boolean paramBoolean, String paramString, ConfirmCallback paramConfirmCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.WindowCallback
 * JD-Core Version:    0.7.0.1
 */