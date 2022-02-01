package com.tencent.mobileqq.util;

import aghw;
import ahav;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import aqfl;
import atad;
import aurs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import ujt;

public final class SystemDragUtils$2
  implements Runnable
{
  public SystemDragUtils$2(ClipData paramClipData, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ProgressDialog paramProgressDialog) {}
  
  public void run()
  {
    Object localObject3;
    Object localObject2;
    String str1;
    int k;
    for (;;)
    {
      ArrayList localArrayList3;
      ArrayList localArrayList2;
      ArrayList localArrayList1;
      HashMap localHashMap;
      int i;
      try
      {
        localArrayList3 = new ArrayList();
        localArrayList2 = new ArrayList();
        localArrayList1 = new ArrayList();
        localHashMap = new HashMap();
        int j = this.c.getItemCount();
        QLog.d("SystemDragUtils", 1, "drag ClipData.getItemCount=" + j);
        i = 0;
        if (i >= j) {
          break label879;
        }
        ClipData.Item localItem = this.c.getItemAt(i);
        if (localItem == null)
        {
          QLog.d("SystemDragUtils", 1, "drag ClipData.item is null");
        }
        else
        {
          localObject3 = localItem.getText();
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            QLog.d("SystemDragUtils", 2, "drag description.text=" + ((CharSequence)localObject3).length());
            localArrayList3.add(((CharSequence)localObject3).toString());
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("SystemDragUtils", 1, "HandleDragException", localThrowable);
        return;
        localObject3 = localThrowable.getIntent();
        if (localObject3 != null)
        {
          if (!QLog.isColorLevel()) {
            break label1323;
          }
          QLog.d("SystemDragUtils", 2, "drag description.intent.action=" + ((Intent)localObject3).getAction() + ",intent.scheme=" + ((Intent)localObject3).getScheme());
        }
      }
      finally
      {
        if ((this.h != null) && (this.h.isShowing())) {
          this.h.cancel();
        }
      }
      localObject3 = localObject1.getHtmlText();
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SystemDragUtils", 2, "drag description.htmlText=" + ((String)localObject3).length());
        }
        localArrayList3.add(localObject3);
      }
      else
      {
        QLog.d("SystemDragUtils", 1, "drag ClipData.item=" + localObject1.toString());
        Uri localUri = localObject1.getUri();
        localObject2 = this.val$context.getContentResolver();
        localObject3 = null;
        str1 = ((ContentResolver)localObject2).getType(localUri);
        localObject2 = localObject3;
        if (str1 != null)
        {
          localObject2 = localObject3;
          if (str1.split("/") != null)
          {
            localObject2 = localObject3;
            if (str1.split("/").length > 0) {
              localObject2 = str1.split("/")[0];
            }
          }
        }
        String str2 = MimeTypeMap.getSingleton().getExtensionFromMimeType(str1);
        if (QLog.isColorLevel()) {
          QLog.d("SystemDragUtils", 2, "drag description.uri=" + localUri.toString() + ", mimeType=" + (String)localObject2 + "， Extension=" + str2);
        }
        if ("file".equalsIgnoreCase(localUri.getScheme()))
        {
          str1 = localUri.getPath();
          k = ahav.getFileType(str1);
          if (k != 0) {
            break label1341;
          }
          localObject2 = "image";
          break;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SystemDragUtils", 2, "drag  description.path=" + (String)localObject2);
          }
          if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!new File((String)localObject2).exists())) {
            break label1323;
          }
          if ((localObject3 != null) && ("image".equalsIgnoreCase((String)localObject3))) {
            localArrayList2.add(localObject2);
          }
          for (;;)
          {
            localArrayList1.add(localObject2);
            break label1323;
            if (!"content".equalsIgnoreCase(localUri.getScheme())) {
              break label1313;
            }
            str1 = aqfl.a(localUri, this.val$context.getContentResolver());
            if (!TextUtils.isEmpty(str1)) {
              break label1302;
            }
            str1 = aqfl.b(localUri, this.val$context);
            if (QLog.isColorLevel()) {
              QLog.d("SystemDragUtils", 2, "drag description.name=" + str1);
            }
            localObject3 = str1;
            if (TextUtils.isEmpty(str1)) {
              localObject3 = atad.toMD5(localUri.toString()) + "." + str2;
            }
            str1 = aqfl.a(this.val$context, localUri, aqfl.access$200(), (String)localObject3);
            localObject3 = localObject2;
            localObject2 = str1;
            break;
            if ((localObject3 != null) && ("video".equalsIgnoreCase((String)localObject3)))
            {
              localObject3 = new SendVideoActivity.SendVideoInfo();
              ((SendVideoActivity.SendVideoInfo)localObject3).fileSize = new File((String)localObject2).length();
              ((SendVideoActivity.SendVideoInfo)localObject3).duration = ShortVideoUtils.getDuration((String)localObject2);
              localHashMap.put(Integer.valueOf(localArrayList2.size()), localObject3);
              localArrayList2.add(localObject2);
            }
          }
          label879:
          QLog.d("SystemDragUtils", 1, "drag textList size is " + localArrayList3.size() + ",mediaList size is " + localArrayList2.size() + ",videoList size is " + localHashMap.size() + ", fileList size is " + localArrayList1.size());
          if (localArrayList3.size() > 0)
          {
            localObject2 = localArrayList3.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              ujt.e(this.val$app, this.val$context, this.l, (String)localObject3);
            }
          }
          if ((localArrayList2.size() > 0) && (localArrayList2.size() == localArrayList1.size()))
          {
            aurs.runOnUiThread(new SystemDragUtils.2.1(this, localArrayList2, localHashMap));
            if ((this.h == null) || (!this.h.isShowing())) {
              break;
            }
            this.h.cancel();
            return;
          }
          if (localArrayList1.size() > 0)
          {
            localObject2 = BaseApplicationImpl.sApplication.getRuntime();
            if ((localObject2 != null) && ((localObject2 instanceof QQAppInterface)))
            {
              aurs.runOnUiThread(new SystemDragUtils.2.2(this));
              if (this.l.cZ == 1)
              {
                localObject3 = localArrayList1.iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  str1 = (String)((Iterator)localObject3).next();
                  ((QQAppInterface)localObject2).a().aV(str1, this.l.aTl);
                }
              }
              localObject3 = localArrayList1.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                str1 = (String)((Iterator)localObject3).next();
                ((QQAppInterface)localObject2).a().a(str1, this.l.aTl, this.l.aTl, this.l.cZ, true);
              }
              aurs.runOnUiThread(new SystemDragUtils.2.3(this));
            }
            if ((this.h == null) || (!this.h.isShowing())) {
              break;
            }
            this.h.cancel();
            return;
          }
          if ((this.h == null) || (!this.h.isShowing())) {
            break;
          }
          this.h.cancel();
          return;
          label1302:
          localObject3 = localObject2;
          localObject2 = str1;
          continue;
          label1313:
          localObject3 = localObject2;
          localObject2 = null;
        }
      }
      label1323:
      i += 1;
    }
    for (;;)
    {
      localObject3 = localObject2;
      localObject2 = str1;
      break;
      label1341:
      if (k == 2) {
        localObject2 = "video";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils.2
 * JD-Core Version:    0.7.0.1
 */