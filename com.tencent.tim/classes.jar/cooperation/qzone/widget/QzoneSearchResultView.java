package cooperation.qzone.widget;

import acff;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqhu;
import aqmu;
import avpw;
import avpw.d;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.ResultItem;
import java.util.List;

public class QzoneSearchResultView
  extends LinearLayout
{
  public ImageView HG;
  public TextView YJ;
  public QzoneImagesContainer a;
  public TextView agC;
  private AccountSearchPb.ResultItem b;
  public TextView iX;
  public TextView titleView;
  
  public QzoneSearchResultView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QzoneSearchResultView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void c(FragmentActivity paramFragmentActivity, String paramString)
  {
    avpw.forwardToBrowser(paramFragmentActivity, paramString, -1, null, null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SearchBaseFragment paramSearchBaseFragment, AccountSearchPb.ResultItem paramResultItem)
  {
    if ((paramResultItem == null) || (paramSearchBaseFragment == null) || (paramQQAppInterface == null))
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    this.b = paramResultItem;
    Object localObject1 = ((acff)paramQQAppInterface.getManager(51)).e(getUin());
    paramQQAppInterface = "";
    if (localObject1 != null) {
      paramQQAppInterface = ((Friends)localObject1).name;
    }
    Object localObject3 = paramResultItem.nick_name.get().toStringUtf8();
    Object localObject2 = paramResultItem.name.get().toStringUtf8();
    String str = paramResultItem.summary.get().toStringUtf8();
    localObject1 = paramResultItem.pic_url_list.get();
    int i = paramResultItem.total_pic_num.get();
    long l = paramResultItem.ftime.get();
    CharSequence localCharSequence = aqmu.a(getContext(), 3, 1000L * l, false);
    localObject3 = paramSearchBaseFragment.a(80000004, (String)localObject3);
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      this.agC.setText((CharSequence)localObject3);
      if (l <= 0L) {
        break label324;
      }
      this.iX.setText(localCharSequence);
      label185:
      paramQQAppInterface = paramSearchBaseFragment.a(80000004, (String)localObject2);
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        break label336;
      }
      this.titleView.setVisibility(8);
      this.YJ.setMaxLines(2);
      this.YJ.setEllipsize(TextUtils.TruncateAt.END);
      label228:
      paramQQAppInterface = paramSearchBaseFragment.a(80000004, str);
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        break label397;
      }
      this.YJ.setVisibility(8);
    }
    for (;;)
    {
      boolean bool = "1".equals(paramResultItem.has_video.get().toStringUtf8());
      this.a.setImages((List)localObject1, i, bool);
      return;
      if (!TextUtils.isEmpty(paramQQAppInterface))
      {
        paramQQAppInterface = paramSearchBaseFragment.a(80000004, paramQQAppInterface);
        this.agC.setText(paramQQAppInterface);
        break;
      }
      this.agC.setText(getUin());
      break;
      label324:
      this.iX.setVisibility(8);
      break label185;
      label336:
      this.titleView.setVisibility(0);
      localObject2 = new SpannableStringBuilder("《");
      ((SpannableStringBuilder)localObject2).append(paramQQAppInterface).append("》");
      this.titleView.setText((CharSequence)localObject2);
      this.YJ.setMaxLines(1);
      this.YJ.setEllipsize(TextUtils.TruncateAt.END);
      break label228;
      label397:
      this.YJ.setText(paramQQAppInterface);
    }
  }
  
  public void g(FragmentActivity paramFragmentActivity)
  {
    avpw.a(paramFragmentActivity, avpw.d.a(), this.b.jmp_url.get().toStringUtf8(), -1);
  }
  
  public String getUin()
  {
    return String.valueOf(this.b.uin.get());
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.HG = ((ImageView)findViewById(2131368406));
    this.agC = ((TextView)findViewById(2131367127));
    this.iX = ((TextView)findViewById(2131373827));
    this.titleView = ((TextView)findViewById(2131379769));
    this.YJ = ((TextView)findViewById(2131379009));
    this.a = ((QzoneImagesContainer)findViewById(2131368895));
  }
  
  public void setAvartaView(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.HG.setVisibility(0);
      this.HG.setImageBitmap(paramBitmap);
      return;
    }
    this.HG.setVisibility(0);
    this.HG.setImageBitmap(aqhu.G());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.widget.QzoneSearchResultView
 * JD-Core Version:    0.7.0.1
 */