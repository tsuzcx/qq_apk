import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import java.util.ArrayList;

class xyl
  extends acdv
{
  xyl(xyi paramxyi) {}
  
  protected void N(boolean paramBoolean, String paramString)
  {
    if ((this.this$0.sessionInfo.aTl.equals(paramString)) && (this.this$0.sessionInfo.cZ == 3000))
    {
      paramString = ((acdu)this.this$0.app.getManager(53)).a(paramString);
      if ((paramString != null) && (paramString.discussionName != null))
      {
        this.this$0.sessionInfo.aTn = paramString.discussionName;
        this.this$0.b(this.this$0.sessionInfo.aTn, paramString.uin, this.this$0.mTitleText);
      }
    }
  }
  
  protected void V(boolean paramBoolean, String paramString)
  {
    if (this.this$0.sessionInfo.aTl.equals(paramString)) {
      this.this$0.finish();
    }
  }
  
  protected void p(boolean paramBoolean, Object paramObject)
  {
    paramObject = (ArrayList)paramObject;
    int i = paramObject.indexOf(this.this$0.sessionInfo.aTl);
    if ((i != -1) && (paramBoolean))
    {
      if (((Boolean)paramObject.get(i + 1)).booleanValue()) {
        this.this$0.aG(false, false);
      }
      if (this.this$0.sessionInfo.cZ == 3000)
      {
        paramObject = ((acdu)this.this$0.app.getManager(53)).a(this.this$0.sessionInfo.aTl);
        if ((paramObject != null) && (paramObject.discussionName != null))
        {
          this.this$0.sessionInfo.aTn = paramObject.discussionName;
          this.this$0.b(this.this$0.sessionInfo.aTn, paramObject.uin, this.this$0.mTitleText);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xyl
 * JD-Core Version:    0.7.0.1
 */