package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem.PicData;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem.ReadInJoyDraftboxContent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.HotPicData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import liq;
import mjt;
import mkt;

class ReadInJoyDeliverUGCActivity$13
  implements Runnable
{
  ReadInJoyDeliverUGCActivity$13(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void run()
  {
    ReadInJoyDraftboxItem.ReadInJoyDraftboxContent localReadInJoyDraftboxContent = new ReadInJoyDraftboxItem.ReadInJoyDraftboxContent();
    localReadInJoyDraftboxContent.typeList = ReadInJoyDeliverUGCActivity.a(this.this$0);
    ReadInJoyDeliverUGCActivity.a(this.this$0, new ArrayList());
    mkt.a(ReadInJoyDeliverUGCActivity.g(this.this$0), this.this$0.app.getCurrentAccountUin(), ReadInJoyDeliverUGCActivity.b(this.this$0), ReadInJoyDeliverUGCActivity.a(this.this$0));
    localReadInJoyDraftboxContent.multiBiuStruct = ReadInJoyDeliverUGCActivity.a(this.this$0);
    localReadInJoyDraftboxContent.srcSize = ReadInJoyDeliverUGCActivity.d(this.this$0);
    localReadInJoyDraftboxContent.commentString = ReadInJoyDeliverUGCActivity.h(this.this$0).getEditableText().toString();
    localReadInJoyDraftboxContent.adTag = ReadInJoyDeliverUGCActivity.e(this.this$0);
    localReadInJoyDraftboxContent.ugcEditCookie = ReadInJoyDeliverUGCActivity.b(this.this$0);
    localReadInJoyDraftboxContent.topicId = ReadInJoyDeliverUGCActivity.c(this.this$0);
    if ((ReadInJoyDeliverUGCActivity.a(this.this$0).getItems() != null) && (ReadInJoyDeliverUGCActivity.a(this.this$0).getItems().size() > 1))
    {
      localReadInJoyDraftboxContent.adapterList = new ArrayList();
      Iterator localIterator = ReadInJoyDeliverUGCActivity.a(this.this$0).getItems().subList(0, ReadInJoyDeliverUGCActivity.a(this.this$0).getCount() - 1).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        ReadInJoyDraftboxItem.PicData localPicData = new ReadInJoyDraftboxItem.PicData();
        if ((localObject instanceof HotPicData))
        {
          localPicData.b = ((HotPicData)localObject);
          localPicData.type = 0;
          localReadInJoyDraftboxContent.adapterList.add(localPicData);
        }
        else if ((localObject instanceof String))
        {
          localPicData.picPath = ((String)localObject);
          localPicData.type = 1;
          localReadInJoyDraftboxContent.adapterList.add(localPicData);
        }
        else
        {
          localReadInJoyDraftboxContent.adapterList.add(null);
        }
      }
    }
    if (ReadInJoyDeliverUGCActivity.f(this.this$0) != null) {
      ReadInJoyDeliverUGCActivity.b(this.this$0, ReadInJoyDeliverUGCActivity.g(this.this$0).a(ReadInJoyDeliverUGCActivity.e(this.this$0), localReadInJoyDraftboxContent));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity.13
 * JD-Core Version:    0.7.0.1
 */