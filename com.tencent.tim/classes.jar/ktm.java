import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.RectF;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class ktm
{
  public BaseCommentData a;
  private int aLP = 18;
  public int aLQ;
  public int area = 0;
  public ArticleInfo articleInfo;
  public SpannableStringBuilder b;
  public List<SpannableStringBuilder> gw;
  public List<CharSequence> gx;
  public List<CharSequence> gy;
  public CharSequence p;
  public int type;
  
  public ktm(int paramInt1, int paramInt2, BaseCommentData paramBaseCommentData, ArticleInfo paramArticleInfo)
  {
    this.type = paramInt2;
    this.a = paramBaseCommentData;
    this.articleInfo = paramArticleInfo;
    this.area = paramInt1;
    aHk();
  }
  
  public ktm(int paramInt, BaseCommentData paramBaseCommentData, ArticleInfo paramArticleInfo)
  {
    this(0, paramInt, paramBaseCommentData, paramArticleInfo);
  }
  
  private CharSequence a(SubCommentData paramSubCommentData)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (paramSubCommentData.hasTarget())
    {
      localSpannableStringBuilder.append("回复 ");
      int i = localSpannableStringBuilder.length();
      if (!TextUtils.isEmpty(paramSubCommentData.repliedUserNickname))
      {
        localSpannableStringBuilder.append(paramSubCommentData.repliedUserNickname);
        localSpannableStringBuilder.setSpan(new ktp(this, paramSubCommentData), i, localSpannableStringBuilder.length(), 33);
        localSpannableStringBuilder.append("：");
      }
    }
    String str = anbk.nn(paramSubCommentData.commentContent);
    paramSubCommentData = str;
    if (localSpannableStringBuilder.length() > 0) {
      paramSubCommentData = localSpannableStringBuilder.append(str);
    }
    return paramSubCommentData;
  }
  
  public static void a(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat1, float paramFloat2)
  {
    RectF localRectF = new RectF();
    if ((paramCanvas == null) || (paramPaint == null)) {
      return;
    }
    float f1 = paramInt3 / 2.0F;
    label34:
    float f2;
    label50:
    label85:
    label101:
    float f3;
    if (paramInt4 > 0)
    {
      paramInt3 = paramInt4;
      f2 = paramInt3;
      if (paramInt6 <= 0) {
        break label491;
      }
      paramInt3 = paramInt2 - paramInt6;
      paramCanvas.drawLine(paramFloat1 + f1, paramFloat2 + f2, paramFloat1 + f1, paramFloat2 + paramInt3, paramPaint);
      if (paramInt4 <= 0) {
        break label497;
      }
      paramInt3 = paramInt4;
      f2 = paramInt3;
      if (paramInt5 <= 0) {
        break label503;
      }
      paramInt3 = paramInt1 - paramInt5;
      paramCanvas.drawLine(paramFloat1 + f2, paramFloat2 + f1, paramFloat1 + paramInt3, paramFloat2 + f1, paramPaint);
      f2 = paramInt1;
      if (paramInt5 <= 0) {
        break label509;
      }
      paramInt3 = paramInt5;
      label140:
      f3 = paramInt3;
      float f4 = paramInt1;
      if (paramInt7 <= 0) {
        break label515;
      }
      paramInt3 = paramInt2 - paramInt7;
      label160:
      paramCanvas.drawLine(f2 + paramFloat1 - f1, paramFloat2 + f3, f4 + paramFloat1 - f1, paramFloat2 + paramInt3, paramPaint);
      if (paramInt6 <= 0) {
        break label521;
      }
      paramInt3 = paramInt6;
      label201:
      f2 = paramInt3;
      f3 = paramInt2;
      if (paramInt7 <= 0) {
        break label527;
      }
    }
    label515:
    label521:
    label527:
    for (paramInt3 = paramInt1 - paramInt7;; paramInt3 = paramInt1)
    {
      paramCanvas.drawLine(paramFloat1 + f2, f3 + paramFloat2 - f1, paramFloat1 + paramInt3, paramInt2 + paramFloat2 - f1, paramPaint);
      if (paramInt4 > 0)
      {
        localRectF.set(paramFloat1, paramFloat2, paramInt4 * 2 + paramFloat1, paramInt4 * 2 + paramFloat2);
        localRectF.offset(f1, f1);
        paramCanvas.drawArc(localRectF, 180.0F, 90.0F, false, paramPaint);
      }
      if (paramInt5 > 0)
      {
        localRectF.set(paramInt1 + paramFloat1 - paramInt5 * 2, paramFloat2, paramInt1 + paramFloat1, paramInt5 * 2 + paramFloat2);
        localRectF.offset(-f1, f1);
        paramCanvas.drawArc(localRectF, 270.0F, 90.0F, false, paramPaint);
      }
      if (paramInt7 > 0)
      {
        localRectF.set(paramInt1 + paramFloat1 - paramInt7 * 2, paramInt2 + paramFloat2 - paramInt7 * 2, paramInt1 + paramFloat1, paramInt2 + paramFloat2);
        localRectF.offset(-f1, -f1);
        paramCanvas.drawArc(localRectF, 0.0F, 90.0F, false, paramPaint);
      }
      if (paramInt6 <= 0) {
        break;
      }
      localRectF.set(paramFloat1, paramInt2 + paramFloat2 - paramInt6 * 2, paramInt6 * 2 + paramFloat1, paramInt2 + paramFloat2);
      localRectF.offset(f1, -f1);
      paramCanvas.drawArc(localRectF, 90.0F, 90.0F, false, paramPaint);
      return;
      paramInt3 = 0;
      break label34;
      label491:
      paramInt3 = paramInt2;
      break label50;
      label497:
      paramInt3 = 0;
      break label85;
      label503:
      paramInt3 = paramInt1;
      break label101;
      label509:
      paramInt3 = 0;
      break label140;
      paramInt3 = paramInt2;
      break label160;
      paramInt3 = 0;
      break label201;
    }
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    paramSpannableStringBuilder.append(" ");
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(" 作者 ");
    paramSpannableStringBuilder.setSpan(new ktm.a(null), i, paramSpannableStringBuilder.length(), 33);
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder, String paramString1, String paramString2, String paramString3, BaseCommentData paramBaseCommentData)
  {
    int i = paramSpannableStringBuilder.length();
    paramSpannableStringBuilder.append(paramString1);
    paramSpannableStringBuilder.setSpan(new ktq(this, paramBaseCommentData, paramString2, paramString3), i, paramSpannableStringBuilder.length(), 33);
  }
  
  private void aHl()
  {
    if ((this.a == null) || (!this.a.isAd) || (this.a.advertisementInfo == null)) {}
    do
    {
      return;
      AdvertisementInfo localAdvertisementInfo = this.a.advertisementInfo;
      if (!TextUtils.isEmpty(localAdvertisementInfo.mAdTxt)) {
        this.p = new aofk(anbk.nn(localAdvertisementInfo.mAdTxt), 3, this.aLP);
      }
      if (this.gy != null) {
        this.gy.clear();
      }
    } while (this.gw == null);
    this.gw.clear();
  }
  
  private String aZ(int paramInt)
  {
    switch (paramInt)
    {
    }
    return "";
  }
  
  public boolean AA()
  {
    return (!TextUtils.isEmpty(this.b)) || ((this.gx != null) && (this.gx.size() > 0) && (this.gw != null) && (this.gw.size() > 0));
  }
  
  public void aHk()
  {
    if (this.a == null) {
      return;
    }
    label44:
    label62:
    label111:
    List localList;
    int j;
    int i;
    if (this.gw == null)
    {
      this.gw = new ArrayList();
      if (this.gx != null) {
        break label257;
      }
      this.gx = new ArrayList();
      if (this.gy != null) {
        break label269;
      }
      this.gy = new ArrayList();
      if (!TextUtils.isEmpty(this.a.commentContent))
      {
        if (!(this.a instanceof CommentData)) {
          break label281;
        }
        this.p = new aofk(anbk.nn(this.a.commentContent), 3, this.aLP);
      }
      if ((this.a instanceof CommentData))
      {
        localList = ((CommentData)this.a).subCommentList;
        if ((localList != null) && (localList.size() > 0))
        {
          j = localList.size();
          i = 0;
          if ((i < j) && (i < 2)) {
            break label311;
          }
        }
      }
      if ((this.a instanceof CommentData))
      {
        localList = ((CommentData)this.a).subCommentList;
        if ((localList != null) && (localList.size() > 0))
        {
          j = localList.size();
          i = 0;
        }
      }
    }
    for (;;)
    {
      label257:
      label269:
      label281:
      label311:
      Object localObject2;
      if ((i >= j) || ((this.gy != null) && (this.gy.size() > 2)))
      {
        aHl();
        return;
        this.gw.clear();
        break;
        this.gx.clear();
        break label44;
        this.gy.clear();
        break label62;
        this.p = new aofk(a((SubCommentData)this.a), 3, this.aLP);
        break label111;
        localObject1 = (SubCommentData)localList.get(i);
        if (localObject1 == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2 = new SpannableStringBuilder();
          if (!TextUtils.isEmpty(((SubCommentData)localObject1).nickName))
          {
            ((SpannableStringBuilder)localObject2).append(((SubCommentData)localObject1).nickName);
            ((SpannableStringBuilder)localObject2).setSpan(new ktn(this, (SubCommentData)localObject1), 0, ((SpannableStringBuilder)localObject2).length(), 33);
          }
          if ((((SubCommentData)localObject1).hasTarget()) && (!TextUtils.isEmpty(((SubCommentData)localObject1).repliedUserNickname)))
          {
            ((SpannableStringBuilder)localObject2).append(" 回复 ");
            int k = ((SpannableStringBuilder)localObject2).length();
            ((SpannableStringBuilder)localObject2).append(((SubCommentData)localObject1).repliedUserNickname);
            ((SpannableStringBuilder)localObject2).setSpan(new kto(this, (SubCommentData)localObject1), k, ((SpannableStringBuilder)localObject2).length(), 33);
          }
          this.gw.add(localObject2);
          if (!TextUtils.isEmpty(((SubCommentData)localObject1).commentContent))
          {
            localObject2 = aZ(((SubCommentData)localObject1).getCommentMediaType());
            localObject1 = new aofk(anbk.nn(((SubCommentData)localObject1).commentContent) + (String)localObject2, 7, this.aLP);
            this.gx.add(localObject1);
          }
        }
      }
      Object localObject1 = (SubCommentData)localList.get(i);
      if ((localObject1 != null) && (((SubCommentData)localObject1).isAuthorReply()))
      {
        localObject2 = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(((SubCommentData)localObject1).nickName))
        {
          a((SpannableStringBuilder)localObject2, ((SubCommentData)localObject1).nickName, ((SubCommentData)localObject1).uin, new krx(this).a().build(), (BaseCommentData)localObject1);
          a((SpannableStringBuilder)localObject2);
        }
        if (!TextUtils.isEmpty(((SubCommentData)localObject1).repliedUserNickname))
        {
          ((SpannableStringBuilder)localObject2).append(" 回复 ");
          a((SpannableStringBuilder)localObject2, ((SubCommentData)localObject1).repliedUserNickname, ((SubCommentData)localObject1).repliedUserUin, new krx(this).a().b(((SubCommentData)localObject1).repliedUserUin).build(), (BaseCommentData)localObject1);
        }
        if (!TextUtils.isEmpty(((SubCommentData)localObject1).commentContent))
        {
          ((SpannableStringBuilder)localObject2).append(" : ");
          String str = aZ(((SubCommentData)localObject1).getCommentMediaType());
          ((SpannableStringBuilder)localObject2).append(new aofk(anbk.nn(((SubCommentData)localObject1).commentContent) + str, 7, this.aLP));
          this.gy.add(localObject2);
        }
      }
      i += 1;
    }
  }
  
  class a
    extends ReplacementSpan
  {
    private a() {}
    
    private float a(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      return paramPaint.measureText(paramCharSequence, paramInt1, paramInt2);
    }
    
    private TextPaint a(Paint paramPaint)
    {
      paramPaint = new TextPaint(paramPaint);
      paramPaint.setTextSize(aqnm.spToPx(9.0F));
      return paramPaint;
    }
    
    public void draw(@NotNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NotNull Paint paramPaint)
    {
      paramPaint.setColor(Color.parseColor("#376099"));
      paramPaint.setTextSize(aqnm.dpToPx(9.0F));
      Paint.FontMetricsInt localFontMetricsInt = paramPaint.getFontMetricsInt();
      int i = localFontMetricsInt.bottom - localFontMetricsInt.top;
      Math.abs(localFontMetricsInt.leading);
      Math.abs(localFontMetricsInt.ascent);
      Math.abs(localFontMetricsInt.descent);
      paramPaint.setAntiAlias(true);
      RectF localRectF = new RectF();
      localRectF.left = ((int)paramFloat);
      int j = (paramInt5 - paramInt3 - localFontMetricsInt.descent + localFontMetricsInt.top) / 2;
      localRectF.top = (paramInt3 + j);
      localRectF.bottom = (paramInt5 - j);
      localRectF.right = (localRectF.left + (int)paramPaint.measureText(paramCharSequence, paramInt1, paramInt2));
      paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt4 - localFontMetricsInt.descent, paramPaint);
      ktm.a(paramCanvas, paramPaint, (int)a(paramPaint, paramCharSequence, paramInt1, paramInt2), i, aqnm.dpToPx(1.0F), aqnm.dpToPx(1.0F), aqnm.dpToPx(1.0F), aqnm.dpToPx(1.0F), aqnm.dpToPx(1.0F), paramFloat, paramInt4 - i);
    }
    
    public int getSize(@NotNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
    {
      paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
      return (int)a(paramPaint).measureText(paramCharSequence.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ktm
 * JD-Core Version:    0.7.0.1
 */