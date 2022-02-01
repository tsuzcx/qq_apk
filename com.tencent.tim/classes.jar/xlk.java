import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQStoryFeed;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;

public class xlk
  extends wjd
{
  private static SimpleDateFormat sDateFormat;
  private MessageForQQStoryFeed jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed;
  private xlk.a jdField_a_of_type_Xlk$a;
  private boolean bhG;
  private View.OnTouchListener f = new xll(this);
  
  public xlk(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private View a(View paramView, xlk.a parama)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131558917, null);
      parama.dp = ((ViewGroup)paramView.findViewById(2131370196));
      parama.c = ((CornerImageView)paramView.findViewById(2131369911));
      parama.to = ((ImageView)paramView.findViewById(2131369913));
      parama.Jr = ((TextView)paramView.findViewById(2131380796));
      parama.Js = ((TextView)paramView.findViewById(2131380701));
      parama.Jt = ((TextView)paramView.findViewById(2131380692));
      parama.tp = ((ImageView)paramView.findViewById(2131369744));
      cdX();
      this.jdField_a_of_type_Xlk$a.dp.setOnTouchListener(this.f);
      this.jdField_a_of_type_Xlk$a.Jr.setText(l());
      this.jdField_a_of_type_Xlk$a.Js.setText(k());
      pu();
      fv(paramView);
      localView = paramView;
      if (aTl)
      {
        parama.E = new StringBuilder();
        localView = paramView;
      }
    }
    if (aTl)
    {
      localView.setContentDescription(null);
      parama.E.setLength(0);
    }
    return localView;
  }
  
  public static CharSequence a(Context paramContext, long paramLong)
  {
    if (sDateFormat == null) {
      sDateFormat = (SimpleDateFormat)DateFormat.getDateFormat(paramContext);
    }
    sDateFormat.applyPattern(String.format("M%sd%s HH:mm", new Object[] { paramContext.getString(2131695973), paramContext.getString(2131692436) }));
    return DateFormat.format(sDateFormat.toLocalizedPattern(), paramLong);
  }
  
  private boolean a(View paramView, MessageForQQStoryFeed paramMessageForQQStoryFeed)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQStoryFeedItemBuilder", 2, "setFeedViewVisibility invoked. info: empty msg. ");
      }
      paramView.setVisibility(8);
    }
    return true;
  }
  
  private URLDrawable b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = wja.dp2px(this.mContext.getResources().getDimension(2131299496), this.mContext.getResources());
    int j = wja.dp2px(this.mContext.getResources().getDimension(2131299500), this.mContext.getResources());
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = j;
    localURLDrawableOptions.mRequestHeight = i;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  private void cdX()
  {
    URLDrawable localURLDrawable = b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mCoverUrl);
    if (localURLDrawable == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQStoryFeedItemBuilder", 2, "setupCover invoked. info: drawable: " + localURLDrawable);
      }
      return;
    }
    this.jdField_a_of_type_Xlk$a.c.setPressMask(true);
    int i = wja.dp2px(10.0F, this.mContext.getResources());
    this.jdField_a_of_type_Xlk$a.c.setRadius(new float[] { i, i, i, i, 0.0F, 0.0F, 0.0F, 0.0F });
    this.jdField_a_of_type_Xlk$a.c.setImageDrawable(localURLDrawable);
  }
  
  private void fv(View paramView)
  {
    if (aTl)
    {
      this.jdField_a_of_type_Xlk$a.E.append(this.jdField_a_of_type_Xlk$a.Jr.getText());
      paramView.setContentDescription(this.jdField_a_of_type_Xlk$a.E.toString());
    }
  }
  
  private void fw(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mUnionId;
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mFeedId;
    rar.a("aio_msg", "aio_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.frienduin });
    qgg.a(BaseActivity.sTopActivity, paramView, str, 1, 109, 1, this.jdField_a_of_type_Xlk$a.c);
  }
  
  private CharSequence k()
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mFeedTime;
    return a(this.mContext, l * 1000L);
  }
  
  private CharSequence l()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mMainText;
  }
  
  private String pu()
  {
    String str = aqft.aI(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mFeedAddress, 10);
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_Xlk$a.Jt.setText(str);
      return str;
    }
    this.jdField_a_of_type_Xlk$a.Jt.setVisibility(4);
    this.jdField_a_of_type_Xlk$a.tp.setVisibility(4);
    return str;
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    if (!(paramMessageRecord instanceof MessageForQQStoryFeed))
    {
      paramMessageRecord = paramView;
      if (QLog.isColorLevel())
      {
        QLog.e("QQStoryFeedItemBuilder", 2, "getItemView Failed. info: wrong message type. ");
        paramMessageRecord = paramView;
      }
    }
    do
    {
      return paramMessageRecord;
      paramMessageRecord = (MessageForQQStoryFeed)MessageForQQStoryFeed.class.cast(paramMessageRecord);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed == null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed = new MessageForQQStoryFeed(paramMessageRecord);
      }
      if (this.jdField_a_of_type_Xlk$a == null) {
        this.jdField_a_of_type_Xlk$a = ((xlk.a)xlk.a.class.cast(parama));
      }
      parama = a(paramView, this.jdField_a_of_type_Xlk$a);
      paramMessageRecord = parama;
    } while (this.bhG);
    this.bhG = a(parama, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed);
    return parama;
  }
  
  protected wjd.a a()
  {
    return new xlk.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public aqob[] a(View paramView)
  {
    return null;
  }
  
  public static class a
    extends wjd.a
  {
    TextView Jr;
    TextView Js;
    TextView Jt;
    CornerImageView c;
    ViewGroup dp;
    ImageView to;
    ImageView tp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xlk
 * JD-Core Version:    0.7.0.1
 */