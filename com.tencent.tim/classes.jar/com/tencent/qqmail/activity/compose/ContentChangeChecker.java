package com.tencent.qqmail.activity.compose;

import android.text.TextUtils;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import java.util.ArrayList;

public class ContentChangeChecker
{
  public static boolean attachChanged(ArrayList<AttachInfo> paramArrayList1, ArrayList<AttachInfo> paramArrayList2)
  {
    if ((paramArrayList1 == null) || (paramArrayList2 == null)) {}
    label83:
    for (;;)
    {
      return false;
      if (paramArrayList1.size() != paramArrayList2.size()) {
        return true;
      }
      int i = 0;
      for (;;)
      {
        if (i >= paramArrayList1.size()) {
          break label83;
        }
        AttachInfo localAttachInfo1 = (AttachInfo)paramArrayList1.get(i);
        AttachInfo localAttachInfo2 = (AttachInfo)paramArrayList2.get(i);
        if ((localAttachInfo1 == null) || (localAttachInfo2 == null)) {
          break;
        }
        if (!TextUtils.equals(localAttachInfo1.getAttachName(), localAttachInfo2.getAttachName())) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean contactsChanged(ArrayList<Object> paramArrayList1, ArrayList<Object> paramArrayList2)
  {
    if ((paramArrayList1 == null) || (paramArrayList2 == null)) {}
    label71:
    for (;;)
    {
      return false;
      if (paramArrayList1.size() != paramArrayList2.size()) {
        return true;
      }
      int i = 0;
      for (;;)
      {
        if (i >= paramArrayList1.size()) {
          break label71;
        }
        Object localObject1 = paramArrayList1.get(i);
        Object localObject2 = paramArrayList2.get(i);
        if ((localObject1 == null) || (localObject2 == null)) {
          break;
        }
        if (!localObject1.equals(localObject2)) {
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ContentChangeChecker
 * JD-Core Version:    0.7.0.1
 */