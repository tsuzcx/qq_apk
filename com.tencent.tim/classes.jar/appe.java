import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.DynamicDrawableSpan;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class appe
  extends DynamicDrawableSpan
{
  private static String cqr = "startPos";
  public long arQ;
  public String cqq;
  protected View.OnClickListener ga;
  public String mAtInfoStr;
  protected Context mContext;
  public Drawable mDrawable;
  public long mSourceMsgSenderUin;
  public long mSourceMsgSeq;
  public int mSourceSummaryFlag;
  protected int maxWidth;
  public long origUid;
  
  private appe(Context paramContext, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, int paramInt, Paint paramPaint, View.OnClickListener paramOnClickListener)
  {
    super(0);
    this.mSourceMsgSeq = paramSourceMsgInfo.mSourceMsgSeq;
    this.cqq = paramSourceMsgInfo.mSourceMsgText;
    this.mSourceMsgSenderUin = paramSourceMsgInfo.mSourceMsgSenderUin;
    this.arQ = paramSourceMsgInfo.mSourceMsgTime;
    this.mSourceSummaryFlag = paramSourceMsgInfo.mSourceSummaryFlag;
    this.maxWidth = paramInt;
    this.mContext = paramContext;
    this.origUid = paramSourceMsgInfo.origUid;
    this.mAtInfoStr = k(this.mSourceMsgSenderUin, paramSourceMsgInfo.mAtInfoStr);
    L(paramOnClickListener);
    c(paramPaint);
  }
  
  public static appe a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, int paramInt, Paint paramPaint, View.OnClickListener paramOnClickListener)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramSourceMsgInfo == null) || (paramInt <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ReplyedMessageSpan", 2, "create reply message span failed: source=" + paramSourceMsgInfo + ", width=" + paramInt);
      }
      return null;
    }
    return new appe(paramContext, paramSourceMsgInfo, paramInt, paramPaint, paramOnClickListener);
  }
  
  private void c(Paint paramPaint)
  {
    if (this.mDrawable != null) {}
    do
    {
      do
      {
        return;
        paramPaint = new SpannableStringBuilder();
        paramPaint.append(aqpm.a(this.cqq, this.mAtInfoStr, ChatTextSizeSettingActivity.vp(), null, 7));
        localObject = new TextView(this.mContext);
        ((TextView)localObject).setSingleLine();
        ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject).setBackgroundDrawable(((TextView)localObject).getResources().getDrawable(2130838355));
        ((TextView)localObject).setGravity(16);
        i = ((TextView)localObject).getResources().getColor(2131167399);
        ((TextView)localObject).setTextColor(Color.argb(230, (0xFF0000 & i) >> 16, (0xFF00 & i) >> 8, i & 0xFF));
        ((TextView)localObject).setText(paramPaint);
        ((TextView)localObject).setTextSize(1, 13.0F);
        i = (int)aqho.convertDpToPixel(this.mContext, 6.0F);
        j = (int)aqho.convertDpToPixel(this.mContext, 23.0F);
        ((TextView)localObject).setPadding(i, 0, i, 0);
        ((TextView)localObject).setMaxWidth(this.maxWidth);
        ((TextView)localObject).setWidth(this.maxWidth);
        ((TextView)localObject).setHeight(j);
        ((TextView)localObject).setTypeface(lf.a(Long.toString(this.mSourceMsgSenderUin)));
        ((TextView)localObject).measure(this.maxWidth, View.MeasureSpec.makeMeasureSpec(0, 0));
        ((TextView)localObject).layout(0, 0, ((TextView)localObject).getMeasuredWidth(), ((TextView)localObject).getMeasuredHeight());
        ((TextView)localObject).setDrawingCacheEnabled(true);
        paramPaint = ((TextView)localObject).getDrawingCache();
      } while (paramPaint == null);
      this.mDrawable = new BitmapDrawable(this.mContext.getResources(), paramPaint);
    } while (this.mDrawable == null);
    int i = this.mDrawable.getIntrinsicHeight();
    Object localObject = this.mDrawable;
    int j = paramPaint.getWidth();
    if (i > 0) {}
    for (;;)
    {
      ((Drawable)localObject).setBounds(0, 0, j, i);
      return;
      i = 0;
    }
  }
  
  public static String k(long paramLong, String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      Object localObject = new JSONArray(paramString);
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      for (;;)
      {
        if (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          if (i == 0)
          {
            if (localJSONObject.optLong("uin") == paramLong) {
              j = localJSONObject.optInt(cqr);
            } else {
              localJSONArray.put(localJSONObject);
            }
          }
          else
          {
            int k = localJSONObject.optInt(cqr, 0);
            if (k > j) {
              localJSONObject.put(cqr, k - j);
            }
            localJSONArray.put(localJSONObject);
          }
        }
        else
        {
          if (localJSONArray.length() == 0) {
            return null;
          }
          localObject = localJSONArray.toString();
          return localObject;
        }
        i += 1;
      }
      return paramString;
    }
    catch (JSONException localJSONException) {}
  }
  
  public void L(View.OnClickListener paramOnClickListener)
  {
    this.ga = paramOnClickListener;
  }
  
  public void Q(TextView paramTextView)
  {
    if (this.ga != null) {
      this.ga.onClick(paramTextView);
    }
  }
  
  public Drawable getDrawable()
  {
    return this.mDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     appe
 * JD-Core Version:    0.7.0.1
 */