package com.tencent.mobileqq.ark;

import acfp;
import adpd;
import adpf;
import adqu;
import adrd;
import adrl;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import ujt;
import wyv;

public class ArkAdapterItemForTextMsg$2$1
  implements Runnable
{
  public ArkAdapterItemForTextMsg$2$1(adpf paramadpf) {}
  
  public void run()
  {
    try
    {
      if (this.a.jdField_a_of_type_Adpd.a.mArkContainer == null)
      {
        adpd.a(this.a.jdField_a_of_type_Adpd, this.a.jdField_a_of_type_Adrd.mContext);
        return;
      }
      ArkAppMessage localArkAppMessage = new ArkAppMessage();
      localArkAppMessage.appMinVersion = "0.0.0.1";
      localArkAppMessage.appName = this.a.jdField_a_of_type_Adpd.a.mArkContainer.getAppName();
      if (TextUtils.isEmpty(localArkAppMessage.appName))
      {
        adpd.a(this.a.jdField_a_of_type_Adpd, this.a.jdField_a_of_type_Adrd.mContext);
        return;
      }
    }
    catch (Exception localException)
    {
      adpd.a(this.a.jdField_a_of_type_Adpd, this.a.jdField_a_of_type_Adrd.mContext);
      if (QLog.isColorLevel())
      {
        QLog.d("ArkAdapterItemForTextMsg", 2, "setSendClick parse ark app exception=" + localException);
        return;
        Object localObject1 = ArkAppCacheMgr.getApplicationFromManifest(localException.appName, localException.appMinVersion);
        if (localObject1 != null)
        {
          localException.appDesc = ((String)((Map)localObject1).get("desc"));
          localException.appMinVersion = ((String)((Map)localObject1).get("version"));
        }
        if (TextUtils.isEmpty(localException.appDesc)) {
          localException.appDesc = localException.appName;
        }
        localException.promptText = String.format(acfp.m(2131702773), new Object[] { localException.appDesc });
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("forward", 1);
        ((JSONObject)localObject1).put("autosize", 1);
        ((JSONObject)localObject1).put("type", "card");
        localException.config = ((JSONObject)localObject1).toString();
        localObject1 = this.a.jdField_a_of_type_Adpd.a.mArkContainer.getViewShare();
        Object localObject2;
        int i;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes()));
          localObject2 = ((Document)localObject1).getElementsByTagName("View").item(0);
          if ((localObject2 != null) && (((Node)localObject2).getChildNodes().getLength() > 0) && ((((Node)localObject2).getFirstChild() instanceof Text)))
          {
            localObject2 = ((Node)localObject2).getFirstChild().getNodeValue();
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localException.appView = ((String)localObject2);
              if (!TextUtils.isEmpty(localException.appView))
              {
                localObject2 = ((Document)localObject1).getElementsByTagName("Metadata").item(0);
                if ((localObject2 != null) && (((Node)localObject2).getChildNodes().getLength() > 0))
                {
                  JSONObject localJSONObject = new JSONObject();
                  if (adrl.a(((Node)localObject2).getFirstChild(), localJSONObject))
                  {
                    localException.metaList = localJSONObject.toString();
                    i = 1;
                    localObject1 = MessageForArkApp.getConfigFromXml((Document)localObject1);
                    j = i;
                    if (!TextUtils.isEmpty((CharSequence)localObject1))
                    {
                      localException.config = ((String)localObject1);
                      j = i;
                      if (QLog.isColorLevel()) {
                        QLog.i("ArkApp", 2, "ArkAIAppMsfFlow send get shareView config:" + localException.config);
                      }
                    }
                  }
                }
              }
            }
          }
        }
        for (int j = i;; j = 0)
        {
          if (j == 0)
          {
            if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_Adpd.a.appView)) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_Adpd.a.meta)))
            {
              localException.appView = this.a.jdField_a_of_type_Adpd.a.appView;
              localException.metaList = this.a.jdField_a_of_type_Adpd.a.meta;
            }
          }
          else
          {
            localObject1 = ((FragmentActivity)this.a.jdField_a_of_type_Adrd.mContext).getChatFragment().a();
            if (localObject1 == null) {
              break label744;
            }
            localObject2 = ((BaseChatPie)localObject1).a();
            if ((localObject2 == null) || (((BaseChatPie)localObject1).app == null)) {
              break label744;
            }
            ujt.b(((BaseChatPie)localObject1).app, (SessionInfo)localObject2, localException);
            adqu.a(((BaseChatPie)localObject1).app, localException.appName, "AIOCardSendMessage", 0, 0, 0L, 0L, 0L, "", "");
            return;
          }
          adpd.a(this.a.jdField_a_of_type_Adpd, this.a.jdField_a_of_type_Adrd.mContext);
          return;
          label744:
          adpd.a(this.a.jdField_a_of_type_Adpd, this.a.jdField_a_of_type_Adrd.mContext);
          return;
          i = 0;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAdapterItemForTextMsg.2.1
 * JD-Core Version:    0.7.0.1
 */