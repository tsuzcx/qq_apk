import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.shareGroup.infocard.view.CircleImageView;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;

public class qow
{
  public static boolean Ke()
  {
    return (((psr)psx.a(10)).sw() & 0x1) != 0;
  }
  
  public static void a(Context paramContext, LinearLayout paramLinearLayout, int paramInt1, QQUserUIItem paramQQUserUIItem, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject1 = LayoutInflater.from(paramContext);
    int i = rpq.dip2px(paramContext, paramInt1);
    if ((paramInt2 != 1) || (!paramBoolean))
    {
      localObject1 = ((LayoutInflater)localObject1).inflate(2131561958, null);
      localObject2 = (CircleImageView)((View)localObject1).findViewById(2131368866);
      localObject3 = ((CircleImageView)localObject2).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).height = i;
      ((ViewGroup.LayoutParams)localObject3).width = i;
      ((CircleImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      ((CircleImageView)localObject2).setBorderColor(-1);
      ((CircleImageView)localObject2).setBorderWidth(rpq.dip2px(paramContext, 1.0F));
      rpq.a((ImageView)localObject2, paramQQUserUIItem.headUrl, i, i, new qwg(null, null));
      paramQQUserUIItem = new LinearLayout.LayoutParams(i, i);
      if (paramInt2 != -1) {
        paramQQUserUIItem.setMargins(-wja.dp2px(8.0F, paramContext.getResources()), 0, 0, 0);
      }
      paramLinearLayout.addView((View)localObject1, paramQQUserUIItem);
      return;
    }
    Object localObject2 = ((LayoutInflater)localObject1).inflate(2131561959, null);
    Object localObject3 = (TextView)((View)localObject2).findViewById(2131380111);
    if (paramInt3 > 99) {}
    for (localObject1 = "99+";; localObject1 = paramInt3 + "")
    {
      ((TextView)localObject3).setText((CharSequence)localObject1);
      ((TextView)localObject3).setVisibility(0);
      localObject1 = ((View)localObject2).findViewById(2131368867);
      localObject3 = ((View)localObject1).getLayoutParams();
      paramInt1 = rpq.dip2px(paramContext, paramInt1 - 2);
      ((ViewGroup.LayoutParams)localObject3).height = paramInt1;
      ((ViewGroup.LayoutParams)localObject3).width = paramInt1;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject1 = localObject2;
      break;
    }
  }
  
  public static boolean a(ShareGroupItem paramShareGroupItem)
  {
    boolean bool = true;
    int i = ((psr)psx.a(10)).sw();
    if (paramShareGroupItem.isPublic()) {
      return (i & 0x1) != 0;
    }
    if ((i & 0x2) != 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(ShareGroupFeedItem paramShareGroupFeedItem)
  {
    if (paramShareGroupFeedItem != null)
    {
      paramShareGroupFeedItem = paramShareGroupFeedItem.getOwner();
      if ((paramShareGroupFeedItem != null) && (paramShareGroupFeedItem.type == 2))
      {
        ram.d("ShareGroupUtil", "屏蔽掉圈子类型 %s", paramShareGroupFeedItem);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qow
 * JD-Core Version:    0.7.0.1
 */