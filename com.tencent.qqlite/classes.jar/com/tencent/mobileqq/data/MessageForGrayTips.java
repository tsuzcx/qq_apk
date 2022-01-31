package com.tencent.mobileqq.data;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dds;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForGrayTips
  extends ChatMessage
{
  private static final String KEY_NEW_HIGHTLIGHT_ITEM_TAG = "new_item_tag";
  private static final String TAG = MessageForGrayTips.class.getSimpleName();
  
  public static String getOrginMsg(String paramString)
  {
    int i = paramString.indexOf("                    ##**##");
    if (i == -1) {
      return paramString;
    }
    return paramString.substring(0, i);
  }
  
  public void addHightlightItem(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    int j = 1;
    if (paramInt1 >= paramInt2) {
      return;
    }
    String str1;
    Object localObject2;
    try
    {
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("new_item_tag", true);
      this.extStr = ((JSONObject)localObject1).toString();
      if (paramBundle == null)
      {
        i = -1;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addHightlightItem ==>actionType:" + i);
          }
          str1 = "," + i + "," + paramInt1 + "," + paramInt2;
          localObject1 = str1;
          switch (i)
          {
          case 4: 
            paramInt1 = this.msg.indexOf("                    ##**##");
            if (paramInt1 == -1)
            {
              this.msg = (this.msg + "                    ##**##" + "1" + (String)localObject1);
              return;
            }
            break;
          }
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel())
        {
          QLog.e(TAG, 2, "addHightlightItem JSONException");
          continue;
          i = paramBundle.getInt("key_action");
        }
      }
      localObject2 = paramBundle.getString("troop_mem_uin");
      if (!paramBundle.getBoolean("need_update_nick")) {}
    }
    for (paramInt1 = j;; paramInt1 = 0)
    {
      localObject2 = str1 + "," + paramInt1 + "," + (String)localObject2;
      break;
      localObject2 = paramBundle.getString("key_action_DATA");
      paramBundle = paramBundle.getString("key_a_action_DATA");
      localObject2 = str1 + "," + (String)localObject2 + "," + paramBundle;
      break;
      paramBundle = this.msg.substring(0, paramInt1);
      String str2 = this.msg.substring(paramInt1 + "                    ##**##".length(), this.msg.length());
      paramInt1 = str2.indexOf(',');
      str1 = str2.substring(0, paramInt1);
      str2 = str2.substring(paramInt1, str2.length());
      paramInt1 = Integer.parseInt(str1);
      localObject2 = paramInt1 + 1 + str2 + (String)localObject2;
      this.msg = (paramBundle + "                    ##**##" + (String)localObject2);
      return;
      localObject2 = str1;
      break;
    }
  }
  
  protected void doParse() {}
  
  public SpannableStringBuilder getHightlightMsgText(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool = false;
    int i;
    String str2;
    Object localObject2;
    Object localObject1;
    int i2;
    ArrayList localArrayList;
    int m;
    try
    {
      if (this.extStr != null) {
        bool = new JSONObject(this.extStr).getBoolean("new_item_tag");
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getHightlightMsgText==> isNewHighlitItem:" + bool);
      }
      String str1 = this.msg;
      i = -1;
      if (!TextUtils.isEmpty(str1)) {
        i = str1.indexOf("                    ##**##");
      }
      if (i == -1) {
        return new SpannableStringBuilder(str1);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "getHightlightMsgText JSONException");
        }
        bool = false;
      }
      str2 = this.msg.substring(0, i);
      localObject2 = this.msg.substring(i + "                    ##**##".length(), this.msg.length());
      i = ((String)localObject2).indexOf(',');
      localObject1 = ((String)localObject2).substring(0, i);
      localObject2 = ((String)localObject2).substring(i + 1, ((String)localObject2).length());
      i2 = Integer.parseInt((String)localObject1);
      localArrayList = new ArrayList(i2);
      m = 0;
    }
    int n;
    int j;
    int k;
    label233:
    Object localObject5;
    Object localObject4;
    label366:
    int i1;
    label466:
    long l2;
    long l1;
    if (m < i2)
    {
      n = -1;
      j = 0;
      i = 0;
      if (bool)
      {
        k = 0;
        localObject5 = null;
        localObject1 = localObject2;
        if (bool)
        {
          i = ((String)localObject2).indexOf(',');
          localObject1 = ((String)localObject2).substring(0, i);
          localObject2 = ((String)localObject2).substring(i + 1, ((String)localObject2).length());
          n = Integer.parseInt((String)localObject1);
          i = ((String)localObject2).indexOf(',');
          localObject4 = ((String)localObject2).substring(0, i);
          localObject1 = ((String)localObject2).substring(i + 1, ((String)localObject2).length());
          j = Integer.parseInt((String)localObject4);
          i = ((String)localObject1).indexOf(',');
          if (i == -1) {
            break label532;
          }
          localObject2 = ((String)localObject1).substring(0, i);
          localObject1 = ((String)localObject1).substring(i + 1, ((String)localObject1).length());
          i = Integer.parseInt((String)localObject2);
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "getHightlightMsgText==> actionType:" + n);
        }
        switch (n)
        {
        case 0: 
        default: 
          if (bool)
          {
            localObject4 = null;
            localObject2 = "";
            i1 = j;
            j = i;
            i = i1;
            l2 = 0L;
            l1 = l2;
            if (localObject2 == "") {
              break;
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong((String)localObject2);
        localArrayList.add(new dds(i, j, l1, k, n, (String)localObject4, (String)localObject5));
        m += 1;
        localObject2 = localObject1;
        break;
        k = 1;
        break label233;
        label532:
        i = Integer.parseInt((String)localObject1);
        break label366;
        localObject4 = null;
        localObject2 = "";
        i1 = i;
        i = j;
        j = i1;
        break label466;
        k = ((String)localObject1).indexOf(',');
        localObject2 = ((String)localObject1).substring(0, k);
        localObject1 = ((String)localObject1).substring(k + 1, ((String)localObject1).length());
        i1 = Integer.parseInt((String)localObject2);
        k = ((String)localObject1).indexOf(',');
        if (k != -1)
        {
          localObject2 = ((String)localObject1).substring(0, k);
          localObject1 = ((String)localObject1).substring(k + 1, ((String)localObject1).length());
          localObject4 = null;
          k = i;
          i = j;
          j = k;
          k = i1;
          break label466;
        }
        localObject4 = null;
        localObject2 = localObject1;
        k = i;
        i = j;
        j = k;
        k = i1;
        break label466;
        i1 = ((String)localObject1).indexOf(',');
        if (i1 == -1) {
          break label1502;
        }
        localObject2 = ((String)localObject1).substring(0, i1);
        localObject4 = ((String)localObject1).substring(i1 + 1, ((String)localObject1).length());
        localObject1 = localObject2;
        localObject2 = localObject4;
        i1 = ((String)localObject2).indexOf(',');
        if (i1 != -1)
        {
          localObject5 = ((String)localObject2).substring(0, i1);
          localObject2 = ((String)localObject2).substring(i1 + 1, ((String)localObject2).length());
          localObject4 = localObject1;
          localObject1 = localObject2;
          localObject2 = "";
          i1 = i;
          i = j;
          j = i1;
          break label466;
        }
        localObject5 = localObject2;
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = "";
        i1 = i;
        i = j;
        j = i1;
        break label466;
        i = ((String)localObject1).indexOf(',');
        localObject2 = ((String)localObject1).substring(0, i);
        localObject1 = ((String)localObject1).substring(i + 1, ((String)localObject1).length());
        i = Integer.parseInt((String)localObject2);
        j = ((String)localObject1).indexOf(',');
        localObject2 = ((String)localObject1).substring(0, j);
        localObject1 = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
        j = Integer.parseInt((String)localObject2);
        k = ((String)localObject1).indexOf(',');
        localObject2 = ((String)localObject1).substring(0, k);
        localObject1 = ((String)localObject1).substring(k + 1, ((String)localObject1).length());
        k = Integer.parseInt((String)localObject2);
        i1 = ((String)localObject1).indexOf(',');
        if (i1 != -1)
        {
          localObject2 = ((String)localObject1).substring(0, i1);
          localObject1 = ((String)localObject1).substring(i1 + 1, ((String)localObject1).length());
          localObject4 = null;
          break label466;
        }
        localObject4 = null;
        localObject2 = localObject1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        l1 = l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(TAG, 2, "getHightlightMsgText ==>NumberFormatException");
        l1 = l2;
        continue;
      }
      i = 0;
      while (i < localArrayList.size() - 1)
      {
        j = i + 1;
        while (j < localArrayList.size())
        {
          if (((dds)localArrayList.get(i)).jdField_a_of_type_Int > ((dds)localArrayList.get(j)).jdField_a_of_type_Int)
          {
            localObject1 = (dds)localArrayList.get(i);
            localArrayList.add(i, localArrayList.get(j));
            localArrayList.add(j, localObject1);
          }
          j += 1;
        }
        i += 1;
      }
      localObject5 = (FriendsManagerImp)paramQQAppInterface.getManager(8);
      Iterator localIterator = localArrayList.iterator();
      localObject1 = str2;
      Object localObject3 = "";
      i = 0;
      if (localIterator.hasNext())
      {
        localObject4 = (dds)localIterator.next();
        str2 = (String)localObject3 + ((String)localObject1).substring(0, ((dds)localObject4).jdField_a_of_type_Int - i);
        String str3 = ((String)localObject1).substring(((dds)localObject4).jdField_a_of_type_Int - i, ((dds)localObject4).b - i);
        localObject3 = ((String)localObject1).substring(((dds)localObject4).b - i, ((String)localObject1).length());
        i = ((dds)localObject4).b;
        ((dds)localObject4).jdField_a_of_type_Int = str2.length();
        if (((dds)localObject4).jdField_a_of_type_Boolean) {}
        for (localObject1 = str2 + ((FriendsManagerImp)localObject5).a(this.frienduin, new StringBuilder().append("").append(((dds)localObject4).jdField_a_of_type_Long).toString());; localObject1 = str2 + str3)
        {
          ((dds)localObject4).b = ((String)localObject1).length();
          localObject4 = localObject1;
          localObject1 = localObject3;
          localObject3 = localObject4;
          break;
        }
      }
      localObject1 = new SpannableStringBuilder((String)localObject3 + (String)localObject1);
      i = paramContext.getResources().getColor(2131427372);
      localObject3 = localArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (dds)((Iterator)localObject3).next();
        if (localObject4 != null) {
          ((SpannableStringBuilder)localObject1).setSpan(new MessageForGrayTips.HightlightClickableSpan(this, paramQQAppInterface, i, paramContext, (dds)localObject4), ((dds)localObject4).jdField_a_of_type_Int, ((dds)localObject4).b, 33);
        }
      }
      return localObject1;
      label1502:
      localObject3 = localObject1;
      localObject1 = null;
    }
  }
  
  public void switch2HightlightMsg() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips
 * JD-Core Version:    0.7.0.1
 */