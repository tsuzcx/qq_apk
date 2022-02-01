import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspIconPostfix;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.IconInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UsrIcon;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class pxr
  extends SimpleJob<Void>
{
  pxr(pxq.b paramb, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = this.a.a.icon_info.get();
    HashMap localHashMap = new HashMap();
    ptf localptf = (ptf)psx.a(2);
    Iterator localIterator = paramJobContext.iterator();
    String str;
    QQUserUIItem localQQUserUIItem;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramJobContext = (qqstory_struct.IconInfo)localIterator.next();
        str = paramJobContext.union_id.get().toStringUtf8();
        localQQUserUIItem = localptf.b(str);
        if (localQQUserUIItem != null) {
          if ((paramJobContext.err_code.get() == 0) && (paramJobContext.usr_icon_list.has()) && (paramJobContext.usr_icon_list.size() > 0))
          {
            paramVarArgs = (qqstory_struct.UsrIcon)paramJobContext.usr_icon_list.get(0);
            paramJobContext = paramVarArgs.icon_postfix.get().toStringUtf8();
            paramVarArgs = paramVarArgs.jmp_postfix.get().toStringUtf8();
            if (TextUtils.isEmpty(paramJobContext)) {
              break label309;
            }
            paramJobContext = "https://pub.idqqimg.com/pc/misc/qqstory_icon/" + paramJobContext;
          }
        }
      }
    }
    label309:
    for (;;)
    {
      if (!TextUtils.isEmpty(paramVarArgs)) {
        paramVarArgs = "https://story.now.qq.com/mobile/pages/medal.html?_bid=2473&_wv=1031" + paramVarArgs;
      }
      for (;;)
      {
        localHashMap.put(str, new String[] { paramJobContext, paramVarArgs });
        localQQUserUIItem.setUserIcon(paramJobContext, paramVarArgs);
        for (;;)
        {
          localQQUserUIItem.iconUrlCacheTime = System.currentTimeMillis();
          localptf.a(localQQUserUIItem);
          break;
          localHashMap.put(str, new String[] { "", "" });
          localQQUserUIItem.setUserIcon("", "");
        }
        paramJobContext = new pxq.c();
        paramJobContext.fl = localHashMap;
        pmi.a().dispatch(paramJobContext);
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxr
 * JD-Core Version:    0.7.0.1
 */