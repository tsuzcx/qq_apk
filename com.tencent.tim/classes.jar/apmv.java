import android.content.Context;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.URLThemeImageView;
import java.util.List;

public class apmv
  implements apmt
{
  private apmz a;
  private QQAppInterface app;
  private Context context;
  private SparseArray<apmr> dF;
  private SessionInfo sessionInfo;
  
  apmv(QQAppInterface paramQQAppInterface, Context paramContext, apmz paramapmz, SessionInfo paramSessionInfo)
  {
    this.app = paramQQAppInterface;
    this.context = paramContext;
    this.a = paramapmz;
    this.sessionInfo = paramSessionInfo;
    onInit();
  }
  
  @Nullable
  public apmr.a a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    if (this.dF.get(paramInt1) != null) {
      return ((apmr)this.dF.get(paramInt1)).a(paramInt1, paramList, paramLong1, paramObject, paramLong2, paramLong3, paramInt2);
    }
    return null;
  }
  
  public apmr a(int paramInt)
  {
    if (this.dF.get(paramInt) != null) {
      return ((apmr)this.dF.get(paramInt)).a(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    if (this.dF.get(paramInt) != null) {
      ((apmr)this.dF.get(paramInt)).a(paramInt, paramTextView1, paramTextView2, paramImageView, paramString);
    }
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    if (this.dF.get(paramInt) != null) {
      ((apmr)this.dF.get(paramInt)).a(paramInt, paramObject, paramString);
    }
  }
  
  public boolean a(int paramInt, URLThemeImageView paramURLThemeImageView, String paramString)
  {
    paramInt = getIconRes(paramInt);
    if (paramInt != 0)
    {
      paramURLThemeImageView.setImageDrawable(null);
      paramURLThemeImageView.setImageResource(paramInt);
      return true;
    }
    return false;
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    if (this.dF.get(paramInt) != null) {
      ((apmr)this.dF.get(paramInt)).b(paramInt, paramObject, paramString);
    }
  }
  
  public boolean bt(int paramInt1, int paramInt2)
  {
    if (this.dF.get(paramInt1) != null) {
      return ((apmr)this.dF.get(paramInt1)).bt(paramInt1, paramInt2);
    }
    return false;
  }
  
  public void cbt()
  {
    int i = 0;
    while (i < this.dF.size())
    {
      ((apmr)this.dF.valueAt(i)).cbt();
      i += 1;
    }
    this.dF.clear();
  }
  
  public int getIconRes(int paramInt)
  {
    if (this.dF.get(paramInt) != null) {
      return ((apmr)this.dF.get(paramInt)).getIconRes(paramInt);
    }
    return 0;
  }
  
  public boolean lX(int paramInt)
  {
    if (this.dF.get(paramInt) != null) {
      return ((apmr)this.dF.get(paramInt)).lX(paramInt);
    }
    return false;
  }
  
  public void onInit()
  {
    this.dF = new SparseArray();
    Object localObject = new apmw(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apmx(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apmy(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apna(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apnb(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apnc(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apnd(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apne(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apnf(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apng(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apnh(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apni(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apnj(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apnk(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apnl(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apnn(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apno(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apnp(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apnq(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apnr(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apns(this.app, this.context, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    localObject = new apnm(this.app, this.context, this.a, this.sessionInfo);
    this.dF.put(((apmr)localObject).getType(), localObject);
    int i = 0;
    while (i < this.dF.size())
    {
      ((apmr)this.dF.valueAt(i)).onInit();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apmv
 * JD-Core Version:    0.7.0.1
 */