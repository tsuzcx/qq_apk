package com.tencent.mobileqq.emoticonview;

import afke;
import afoc;
import ajdg;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonKeywords;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.data.EmotionKeyword;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.emosm.EmosmPb.BqAssocInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class EmotionKeywordAdapter$3
  implements Runnable
{
  public EmotionKeywordAdapter$3(afoc paramafoc, EmoticonResp paramEmoticonResp, String paramString) {}
  
  public void run()
  {
    if (this.b.resetKeywordExpose) {
      afoc.a(this.this$0).Mn(afoc.a(this.this$0));
    }
    Object localObject1 = new EmoticonKeywords();
    ((EmoticonKeywords)localObject1).keyword = afoc.a(this.this$0);
    ((EmoticonKeywords)localObject1).lastReqTime = System.currentTimeMillis();
    afoc.a(this.this$0).a((EmoticonKeywords)localObject1);
    localObject1 = this.b.data;
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordAdapter", 2, "handleCloudEmotionForKeywordResp keyword = " + afoc.a(this.this$0) + ",resp size = " + ((List)localObject1).size());
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("handleCloudEmotionForKeywordResp : eId = ");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(afoc.a(this.this$0));
    Object localObject3 = ((List)localObject1).iterator();
    EmosmPb.BqAssocInfo localBqAssocInfo;
    Emoticon localEmoticon;
    while (((Iterator)localObject3).hasNext())
    {
      localBqAssocInfo = (EmosmPb.BqAssocInfo)((Iterator)localObject3).next();
      localEmoticon = new Emoticon();
      localEmoticon.epId = String.valueOf(localBqAssocInfo.u32_tab_id.get());
      localEmoticon.eId = localBqAssocInfo.str_item_id.get();
      localEmoticon.name = localBqAssocInfo.str_item_name.get();
      localEmoticon.encryptKey = localBqAssocInfo.str_item_key.get();
      localEmoticon.ipsiteUrl = localBqAssocInfo.str_ipsite_url.get();
      localEmoticon.ipsiteName = localBqAssocInfo.str_ipsite_name.get();
      if (QLog.isColorLevel()) {
        QLog.d("EmotionKeywordAdapter", 2, "handleCloudEmotionForKeywordResp keyword = " + afoc.a(this.this$0) + "id = " + localEmoticon.epId + " ipSiteName = " + localEmoticon.ipsiteName + " ipsiteUrl = " + localEmoticon.ipsiteUrl);
      }
      if ((!TextUtils.isEmpty(localEmoticon.epId)) && (!TextUtils.isEmpty(localEmoticon.eId)) && (!TextUtils.isEmpty(localEmoticon.encryptKey)))
      {
        localObject1 = localBqAssocInfo.rpt_str_item_keyword.get();
        if (localObject1 != null) {
          break label927;
        }
        localObject1 = new ArrayList();
      }
    }
    label927:
    for (;;)
    {
      if (afoc.a(this.this$0).b(localEmoticon.epId) == null) {
        ((afke)afoc.a(this.this$0).getManager(43)).ex(localEmoticon.epId, afke.cRu);
      }
      label472:
      int i;
      label504:
      boolean bool;
      if (((List)localObject1).size() > 0)
      {
        localObject1 = localObject1.toString();
        localEmoticon.keyword = ((String)localObject1);
        localEmoticon.keywords = ((String)localObject1);
        i = localBqAssocInfo.i32_tab_ringtype.get();
        if (i != 1) {
          break label745;
        }
        localEmoticon.isSound = true;
        localEmoticon.jobType = 0;
        localEmoticon.width = 200;
        localEmoticon.height = 200;
        localEmoticon.businessExtra = "";
        if (localBqAssocInfo.uint32_emoji_type.has())
        {
          if (localBqAssocInfo.uint32_emoji_type.get() != 2) {
            break label753;
          }
          bool = true;
          label559:
          localEmoticon.isAPNG = bool;
        }
        if (!localBqAssocInfo.rpt_apng_support_size.has()) {
          break label758;
        }
        afoc.a(this.this$0).a(localEmoticon.epId, localEmoticon, localBqAssocInfo.rpt_apng_support_size.get());
        label601:
        localObject1 = new EmotionKeyword();
        ((EmotionKeyword)localObject1).keyword = afoc.a(this.this$0).toLowerCase();
        ((EmotionKeyword)localObject1).epId = localEmoticon.epId;
        ((EmotionKeyword)localObject1).eId = localEmoticon.eId;
        afoc.a(this.this$0).a((EmotionKeyword)localObject1);
        afoc.a(this.this$0).e(localEmoticon);
        i = 0;
      }
      for (;;)
      {
        if (i < localArrayList.size())
        {
          localObject1 = (Emoticon)localArrayList.get(i);
          if ((localObject1 != null) && ("NONE".equals(((Emoticon)localObject1).epId))) {
            localArrayList.set(i, localEmoticon);
          }
        }
        else
        {
          ((StringBuilder)localObject2).append(localEmoticon.eId).append(",");
          break;
          localObject1 = this.bED;
          break label472;
          label745:
          if (i != 4) {
            break label504;
          }
          break;
          label753:
          bool = false;
          break label559;
          label758:
          if (!localBqAssocInfo.rpt_support_size.has()) {
            break label601;
          }
          afoc.a(this.this$0).a(localEmoticon.epId, localEmoticon, localBqAssocInfo.rpt_support_size.get());
          break label601;
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmotionKeywordAdapter", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = new ArrayList();
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Emoticon)((Iterator)localObject2).next();
        if ((localObject3 != null) && ("NONE".equals(((Emoticon)localObject3).epId))) {
          ((List)localObject1).add(localObject3);
        }
      }
      if (((List)localObject1).size() > 0) {
        localArrayList.removeAll((Collection)localObject1);
      }
      ThreadManager.getUIHandler().post(new EmotionKeywordAdapter.3.1(this, localArrayList));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionKeywordAdapter.3
 * JD-Core Version:    0.7.0.1
 */