import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.util.FaceDecodeTask;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aqdk
  extends aqdj
{
  aqdk.c jdField_a_of_type_Aqdk$c;
  aqdk.d jdField_a_of_type_Aqdk$d;
  aqdk.e jdField_a_of_type_Aqdk$e;
  WeakReference<QQAppInterface> weakApp;
  
  public aqdk(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, aqdj.a parama, boolean paramBoolean2)
  {
    super(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramInt4, paramBoolean1, paramDrawable1, paramDrawable2, parama, paramBoolean2);
    this.weakApp = new WeakReference((QQAppInterface)paramAppInterface);
  }
  
  private Bitmap e(boolean paramBoolean)
  {
    if (this.c == null) {
      return null;
    }
    Object localObject1 = this.c.uin;
    if (this.c.aRY == 1001) {
      localObject1 = GroupIconHelper.jy(this.c.uin);
    }
    Object localObject2 = (QQAppInterface)this.weakApp.get();
    if (localObject2 == null) {
      return null;
    }
    localObject1 = ((QQAppInterface)localObject2).getBitmapFromCache(((QQAppInterface)localObject2).a(this.c.aRY, (String)localObject1, (byte)this.c.shape, this.c.idType, 100, paramBoolean));
    if ((localObject1 != null) && (this.c.aRY == 1001))
    {
      localObject2 = (acdt)((QQAppInterface)localObject2).getBusinessHandler(6);
      if ((localObject2 != null) && (((acdt)localObject2).a() != null)) {
        ((acdt)localObject2).a().FV(this.c.uin);
      }
    }
    return localObject1;
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, Object paramObject)
  {
    if ((this.mCancelled) || (this.c == null)) {}
    do
    {
      do
      {
        return;
      } while ((paramInt != this.c.aRY) || (!this.c.uin.equals(paramString)));
      if (paramObject == null) {
        break;
      }
      paramString = (QQAppInterface)this.weakApp.get();
    } while (paramString == null);
    paramString = (aqdm)paramString.getManager(170);
    if (paramString != null) {
      paramString.by(paramObject);
    }
    if (paramBoolean)
    {
      paramString = aG();
      if (paramString != null) {
        a(this.c, paramString);
      }
    }
    for (;;)
    {
      System.currentTimeMillis();
      return;
      aBV();
      continue;
      a(this.c, null);
    }
  }
  
  protected boolean aBV()
  {
    if (this.c == null) {
      return false;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.weakApp.get();
    if (localQQAppInterface == null) {
      return false;
    }
    aqdm localaqdm;
    if ((this.c.aRY == 101) || (this.c.aRY == 1001))
    {
      this.jdField_a_of_type_Aqdk$c = new aqdk.c(this);
      localaqdm = (aqdm)localQQAppInterface.getManager(170);
      if (localaqdm != null) {
        localaqdm.bx(this.jdField_a_of_type_Aqdk$c);
      }
    }
    if (((this.c.aRY == 4) || (this.c.aRY == 113)) && (!apuh.ra(this.c.uin)))
    {
      this.jdField_a_of_type_Aqdk$e = new aqdk.e(this);
      localaqdm = (aqdm)localQQAppInterface.getManager(170);
      if (localaqdm != null) {
        localaqdm.bx(this.jdField_a_of_type_Aqdk$e);
      }
    }
    FaceDecodeTask.a(FaceDecodeTask.a(localQQAppInterface, this.c, this));
    return true;
  }
  
  protected Bitmap aG()
  {
    return e(false);
  }
  
  public void cancel()
  {
    Object localObject = (QQAppInterface)this.weakApp.get();
    if ((!this.mCancelled) && (localObject != null))
    {
      aqdm localaqdm;
      if (this.jdField_a_of_type_Aqdk$d != null)
      {
        localaqdm = (aqdm)((QQAppInterface)localObject).getManager(170);
        if (localaqdm != null) {
          localaqdm.by(this.jdField_a_of_type_Aqdk$d);
        }
      }
      if (this.jdField_a_of_type_Aqdk$c != null)
      {
        localaqdm = (aqdm)((QQAppInterface)localObject).getManager(170);
        if (localaqdm != null) {
          localaqdm.by(this.jdField_a_of_type_Aqdk$c);
        }
      }
      if (this.jdField_a_of_type_Aqdk$e != null)
      {
        localObject = (aqdm)((QQAppInterface)localObject).getManager(170);
        if (localObject != null) {
          ((aqdm)localObject).by(this.jdField_a_of_type_Aqdk$e);
        }
      }
      this.weakApp = null;
    }
    super.cancel();
  }
  
  protected Bitmap d(boolean paramBoolean)
  {
    return e(paramBoolean);
  }
  
  protected void edv()
  {
    if (this.jdField_a_of_type_Aqdk$d == null) {
      this.jdField_a_of_type_Aqdk$d = new aqdk.d(this);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.weakApp.get();
    if (localQQAppInterface == null) {
      return;
    }
    Object localObject = (aqdm)localQQAppInterface.getManager(170);
    if (localObject != null) {
      ((aqdm)localObject).bx(this.jdField_a_of_type_Aqdk$d);
    }
    if ((this.c.aRY == 1) || (this.c.aRY == 11) || (this.c.aRY == 4) || (this.c.aRY == 32) || (this.c.aRY == 16) || (this.c.aRY == 1001))
    {
      localObject = (FriendListHandler)localQQAppInterface.getBusinessHandler(1);
      if (this.c.aRY != 1) {
        break label180;
      }
      ((FriendListHandler)localObject).a(this.c.uin, this.c.headLevel, this.c.bA);
    }
    for (;;)
    {
      System.currentTimeMillis();
      return;
      label180:
      if (this.c.aRY == 11) {
        ((FriendListHandler)localObject).c(this.c.uin, this.c.bA);
      } else if (this.c.aRY == 4) {
        ((FriendListHandler)localObject).b(this.c.uin, this.c.bA);
      } else if (this.c.aRY == 32) {
        ((FriendListHandler)localObject).a(this.c.uin, this.c.idType, this.c.headLevel, this.c.bA);
      } else if (this.c.aRY == 16) {
        ((FriendListHandler)localObject).b(this.c.uin, this.c.idType, this.c.headLevel, this.c.bA);
      } else if (this.c.aRY == 101) {
        ((acdt)localQQAppInterface.getBusinessHandler(6)).bA(this.c.uin, true);
      } else if (this.c.aRY == 1001) {
        ((acdt)localQQAppInterface.getBusinessHandler(6)).bA(GroupIconHelper.jy(this.c.uin), true);
      }
    }
  }
  
  protected void setApp(AppInterface paramAppInterface)
  {
    this.weakApp = new WeakReference((QQAppInterface)paramAppInterface);
  }
  
  public static abstract interface a
  {
    public abstract void d(boolean paramBoolean1, boolean paramBoolean2, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void onUpdateCustomHead(boolean paramBoolean, String paramString);
    
    public abstract void onUpdateMobileQQHead(boolean paramBoolean, String paramString);
    
    public abstract void onUpdateQCallHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2);
    
    public abstract void onUpdateStrangerHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2);
    
    public abstract void onUpdateTroopHead(boolean paramBoolean, String paramString);
  }
  
  public class c
    implements aqdk.a
  {
    public String discussionUin;
    
    c(aqdj paramaqdj)
    {
      if ((paramaqdj != null) && (paramaqdj.c != null)) {
        this.discussionUin = paramaqdj.c.uin;
      }
    }
    
    public void d(boolean paramBoolean1, boolean paramBoolean2, String paramString)
    {
      int i;
      if (GroupIconHelper.kH(paramString)) {
        i = 1001;
      }
      for (String str = GroupIconHelper.jz(paramString);; str = paramString)
      {
        if (paramBoolean2) {
          aqdk.this.a(paramBoolean1, i, str, aqdk.this.a);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.FaceDrawableImpl", 2, "====faceDrawableImpl onUpdateDiscussionFaceIcon === isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2 + ",disUin: " + paramString + ",type: " + i);
          }
          return;
          aqdk.this.a(paramBoolean1, i, str, null);
        }
        i = 101;
      }
    }
  }
  
  public class d
    implements aqdk.b
  {
    public WeakReference<aqdj> io;
    public String uin;
    
    d(aqdj paramaqdj)
    {
      this.io = new WeakReference(paramaqdj);
      if ((paramaqdj != null) && (paramaqdj.c != null)) {
        this.uin = paramaqdj.c.uin;
      }
    }
    
    public void onUpdateCustomHead(boolean paramBoolean, String paramString)
    {
      aqdk.this.a(paramBoolean, 1, paramString, aqdk.this.a);
    }
    
    public void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
    {
      aqdk.this.a(paramBoolean, 11, paramString, aqdk.this.a);
    }
    
    public void onUpdateQCallHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
    {
      if ((aqdk.this.c == null) || (paramInt != aqdk.this.c.idType)) {
        return;
      }
      aqdk.this.a(paramBoolean1, 16, paramString, aqdk.this.a);
    }
    
    public void onUpdateStrangerHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
    {
      aqdk.this.a(paramBoolean1, 32, paramString, aqdk.this.a);
    }
    
    public void onUpdateTroopHead(boolean paramBoolean, String paramString)
    {
      aqdk.this.a(paramBoolean, 4, paramString, aqdk.this.a);
    }
  }
  
  public class e
    implements aqdk.f
  {
    public String discussionUin;
    
    e(aqdj paramaqdj)
    {
      if ((paramaqdj != null) && (paramaqdj.c != null)) {
        this.discussionUin = paramaqdj.c.uin;
      }
    }
    
    public void m(boolean paramBoolean1, boolean paramBoolean2, String paramString)
    {
      if (paramBoolean2) {
        aqdk.this.a(paramBoolean1, 113, paramString, aqdk.this.a);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.FaceDrawableImpl", 2, "====faceDrawableImpl onUpdateGroupFaceIcon === isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2 + ",disUin: " + paramString + ",type: " + 113);
        }
        return;
        aqdk.this.a(paramBoolean1, 113, paramString, null);
      }
    }
  }
  
  public static abstract interface f
  {
    public abstract void m(boolean paramBoolean1, boolean paramBoolean2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqdk
 * JD-Core Version:    0.7.0.1
 */