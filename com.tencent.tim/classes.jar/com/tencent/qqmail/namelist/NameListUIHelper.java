package com.tencent.qqmail.namelist;

import android.content.Context;
import android.util.Log;
import android.widget.ListView;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.namelist.cursor.NameListBaseCursor;
import com.tencent.qqmail.namelist.model.NameListContact;
import com.tencent.qqmail.namelist.model.NameListContact.NameListContactType;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.log.QMLog;

public class NameListUIHelper
{
  private static final String TAG = "NameListUIHelper";
  
  public static void scrollTopNewContact(ListView paramListView, NameListBaseCursor paramNameListBaseCursor, long paramLong)
  {
    if ((paramListView != null) && (paramNameListBaseCursor != null)) {}
    for (;;)
    {
      try
      {
        int j = paramNameListBaseCursor.getCount();
        if (j > 0)
        {
          i = 0;
          if (i < j)
          {
            NameListContact localNameListContact = paramNameListBaseCursor.getItem(i);
            if ((localNameListContact != null) && (localNameListContact.getId() == paramLong))
            {
              j = i;
              if (i >= 0)
              {
                j = i;
                if (i < paramNameListBaseCursor.getCount()) {
                  j = i + paramListView.getHeaderViewsCount();
                }
              }
              QMLog.log(4, "NameListUIHelper", "newPos:" + j + " newContactId:" + paramLong);
              if ((j >= 0) && (j < paramNameListBaseCursor.getCount())) {
                paramListView.post(new NameListUIHelper.4(paramListView, j));
              }
              return;
            }
            i += 1;
            continue;
          }
        }
        int i = -1;
      }
      catch (Exception paramListView)
      {
        QMLog.log(6, "NameListUIHelper", Log.getStackTraceString(paramListView));
        return;
      }
    }
  }
  
  public static void showDeleteConfirmDialog(Context paramContext, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    if (paramInt2 == NameListContact.NameListContactType.BLACK.ordinal())
    {
      Object localObject1 = "";
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        str1 = paramArrayOfString[i];
        localObject2 = localObject1;
        if (NameListManager.sharedInstance().isBlackNameExist(paramInt1, str1)) {
          localObject2 = (String)localObject1 + "<" + str1 + ">、";
        }
        i += 1;
        localObject1 = localObject2;
      }
      localObject1 = String.format(paramContext.getString(2131690877), new Object[] { ((String)localObject1).substring(0, ((String)localObject1).length() - 1) });
      Object localObject2 = paramContext.getString(2131696424);
      String str1 = paramContext.getString(2131690894);
      String str2 = QMApplicationContext.sharedInstance().getString(2131691246);
      paramContext = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(paramContext).setMessage((CharSequence)localObject1).setTitle((String)localObject2)).addAction(str2, new NameListUIHelper.2())).addAction(str1, new NameListUIHelper.1(paramInt1, paramInt2, paramArrayOfString))).create();
      paramContext.setOnDismissListener(new NameListUIHelper.3());
      paramContext.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.NameListUIHelper
 * JD-Core Version:    0.7.0.1
 */