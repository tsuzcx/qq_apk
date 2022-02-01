package com.tencent.mobileqq.jsp;

import aiiy;
import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.manager.TicketManager;

public class DocxApiPlugin$2
  implements Runnable
{
  public DocxApiPlugin$2(aiiy paramaiiy, Activity paramActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)((TeamWorkDocEditBrowserActivity)this.val$activity).c();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.bNZ);
    String str1 = new File(this.bNZ).getName();
    String str2 = ((TicketManager)((TeamWorkDocEditBrowserActivity)this.val$activity).mApp.getManager(2)).getSkey(((TeamWorkDocEditBrowserActivity)this.val$activity).mApp.getAccount());
    localObject = ((TeamWorkDocEditBrowserActivity)this.val$activity).a(localArrayList, ((TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)localObject).mSelfUin, str2, "1", ((TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)localObject).mRefer, ((TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)localObject).bLa);
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      localObject = (String)((ArrayList)localObject).get(0);
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkDocEditBrowserActivity", 2, " url = " + (String)localObject + " fileName = " + str1);
      }
      this.this$0.callJs("insertImageForNativeJSBridge('" + (String)localObject + "','" + this.bOa + "','" + str1 + "')");
    }
    do
    {
      return;
      this.this$0.callJs("insertImageForNativeJSBridge('" + null + "','" + this.bOa + "','" + str1 + "')");
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkDocEditBrowserActivity", 2, "picture upload fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DocxApiPlugin.2
 * JD-Core Version:    0.7.0.1
 */