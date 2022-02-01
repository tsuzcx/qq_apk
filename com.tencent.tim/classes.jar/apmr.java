import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.URLThemeImageView;

public abstract class apmr
  implements apmt
{
  protected final String TAG = "Navigate." + getClass().getSimpleName();
  protected QQAppInterface app;
  protected Context context;
  protected int mType = -1;
  protected SessionInfo sessionInfo;
  
  public apmr(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.app = paramQQAppInterface;
    this.context = paramContext;
    this.sessionInfo = paramSessionInfo;
  }
  
  public apmr a(int paramInt)
  {
    return this;
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString) {}
  
  public boolean a(int paramInt, URLThemeImageView paramURLThemeImageView, String paramString)
  {
    return false;
  }
  
  protected boolean a(@NonNull MessageRecord paramMessageRecord, long paramLong1, long paramLong2)
  {
    if ((paramMessageRecord.shmsgseq <= paramLong2) && (QLog.isColorLevel())) {
      QLog.d(this.TAG, 2, "checkShMsgSeqCanShow, shMsgSeq = " + paramMessageRecord.shmsgseq + ", firstMsgSeq = " + paramLong1 + ", lastReadSeq = " + paramLong2);
    }
    return (paramMessageRecord.shmsgseq < paramLong1) && (paramMessageRecord.shmsgseq > paramLong2);
  }
  
  public boolean bt(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void cbt() {}
  
  @DrawableRes
  public int getIconRes(int paramInt)
  {
    return 0;
  }
  
  protected int getType()
  {
    return this.mType;
  }
  
  public boolean lX(int paramInt)
  {
    return true;
  }
  
  public void onInit() {}
  
  static class a
  {
    private Object fl;
    private String senderUin;
    private boolean show;
    private Object tag;
    private String wording;
    
    public a(boolean paramBoolean, String paramString1, Object paramObject, String paramString2)
    {
      this.show = paramBoolean;
      this.wording = paramString1;
      this.tag = paramObject;
      this.senderUin = paramString2;
      this.fl = null;
    }
    
    public a(boolean paramBoolean, String paramString1, Object paramObject1, String paramString2, Object paramObject2)
    {
      this.show = paramBoolean;
      this.wording = paramString1;
      this.tag = paramObject1;
      this.senderUin = paramString2;
      this.fl = paramObject2;
    }
    
    public Object V()
    {
      return this.fl;
    }
    
    public Object getTag()
    {
      return this.tag;
    }
    
    public String hf()
    {
      return this.senderUin;
    }
    
    public String iZ()
    {
      return this.wording;
    }
    
    public boolean isShow()
    {
      return this.show;
    }
    
    public String toString()
    {
      return "Entity{show=" + this.show + ", wording='" + this.wording + ", senderUin='" + this.senderUin + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apmr
 * JD-Core Version:    0.7.0.1
 */