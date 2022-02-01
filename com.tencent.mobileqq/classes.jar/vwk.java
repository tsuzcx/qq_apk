import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.util.Pair;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleDitto.StButton;
import qqcircle.QQCircleDitto.StItemInfo;

public class vwk
{
  public static Pair<Integer, Integer> a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    case 50001: 
      return new Pair(Integer.valueOf(waz.d), Integer.valueOf(waz.e));
    }
    return new Pair(Integer.valueOf(waz.d), Integer.valueOf(waz.f));
  }
  
  public static Pair<Integer, Integer> a(FeedCloudMeta.StFeed paramStFeed, int paramInt1, int paramInt2)
  {
    Pair localPair = new Pair(Integer.valueOf(0), Integer.valueOf(0));
    if (paramStFeed != null)
    {
      if (paramStFeed.type.get() == 3)
      {
        int i = ImmersiveUtils.a();
        float f = paramInt1 / paramInt2;
        if (f >= 1.777778F) {
          paramInt1 = (int)(i / 1.777778F);
        }
        for (;;)
        {
          return new Pair(Integer.valueOf(i), Integer.valueOf(paramInt1));
          if ((f > 0.75F) && (f <= 1.777778F)) {
            paramInt1 = (int)(i / f);
          } else {
            paramInt1 = (int)(i / 0.75F);
          }
        }
      }
      if (paramStFeed.type.get() == 2)
      {
        paramStFeed = paramStFeed.images.get();
        paramInt1 = ImmersiveUtils.a();
        if (paramStFeed.size() > 0)
        {
          paramStFeed = (FeedCloudMeta.StImage)paramStFeed.get(0);
          if ((paramStFeed.width.get() != 0) && (paramStFeed.height.get() != 0)) {
            return new Pair(Integer.valueOf(paramInt1), Integer.valueOf((int)(Math.max(Math.min(paramStFeed.height.get() / paramStFeed.width.get(), 1.333333F), 0.5625F) * paramInt1)));
          }
        }
      }
    }
    return localPair;
  }
  
  public static List<QQCircleDitto.StItemInfo> a(List<QQCircleDitto.StItemInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QQCircleDitto.StItemInfo localStItemInfo = (QQCircleDitto.StItemInfo)paramList.next();
        if ((localStItemInfo != null) && (localStItemInfo.buttonInfo.buttonValue.get() == 0) && (!vqn.a().b(localStItemInfo.id.get()))) {
          localArrayList.add(localStItemInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public static Pair<Integer, Integer> b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    case 0: 
      return new Pair(Integer.valueOf(wch.d), Integer.valueOf(wch.e));
    }
    return new Pair(Integer.valueOf(wch.d), Integer.valueOf(wch.f));
  }
  
  public static List<QQCircleDitto.StItemInfo> b(List<QQCircleDitto.StItemInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QQCircleDitto.StItemInfo localStItemInfo = (QQCircleDitto.StItemInfo)paramList.next();
        if ((localStItemInfo.images.get().size() >= 3) && (localArrayList.size() < 10)) {
          localArrayList.add(localStItemInfo);
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwk
 * JD-Core Version:    0.7.0.1
 */