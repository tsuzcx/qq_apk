package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo.a;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import lhn;
import org.json.JSONException;
import org.json.JSONObject;

public class ChannelCoverInfoModule$8
  implements Runnable
{
  public ChannelCoverInfoModule$8(lhn paramlhn, List paramList1, List paramList2) {}
  
  public void run()
  {
    Object localObject = this.hU.iterator();
    TabChannelCoverInfo localTabChannelCoverInfo;
    while (((Iterator)localObject).hasNext())
    {
      localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject).next();
      this.this$0.b(localTabChannelCoverInfo);
    }
    localObject = this.hV.iterator();
    for (;;)
    {
      JSONObject localJSONObject;
      if (((Iterator)localObject).hasNext())
      {
        localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject).next();
        localTabChannelCoverInfo.setStatus(1000);
        if (localTabChannelCoverInfo.redPoint != null) {
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("startTimestamp", localTabChannelCoverInfo.redPoint.startTimestamp);
        localJSONObject.put("endTimestamp", localTabChannelCoverInfo.redPoint.endTimestamp);
        localJSONObject.put("animationTimestamp", localTabChannelCoverInfo.redPoint.vS);
        localJSONObject.put("isShow", localTabChannelCoverInfo.redPoint.isShow);
        localJSONObject.put("type", localTabChannelCoverInfo.redPoint.type);
        localJSONObject.put("titleText", localTabChannelCoverInfo.redPoint.titleText);
        localJSONObject.put("titleColor", localTabChannelCoverInfo.redPoint.titleColor);
        localJSONObject.put("titleBgColor", localTabChannelCoverInfo.redPoint.wP);
        localTabChannelCoverInfo.redPointJson = localJSONObject.toString();
        label211:
        this.this$0.a(localTabChannelCoverInfo);
        continue;
        if (QLog.isColorLevel())
        {
          localObject = lhn.a(this.this$0);
          if (localObject != null)
          {
            QLog.i("ChannelCoverInfoModule", 2, "now channels in db are:\n");
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              QLog.i("ChannelCoverInfoModule", 2, ((TabChannelCoverInfo)((Iterator)localObject).next()).toString());
            }
          }
          QLog.i("ChannelCoverInfoModule", 2, "now channels in db are null:\n");
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        break label211;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.8
 * JD-Core Version:    0.7.0.1
 */