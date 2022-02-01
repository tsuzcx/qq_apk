import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity.a;
import com.tencent.qphone.base.util.QLog;

public class jby
  extends iid
{
  public jby(MultiVideoMembersListviewAvtivity paramMultiVideoMembersListviewAvtivity) {}
  
  protected void A(long paramLong1, long paramLong2)
  {
    if ((!this.a.Xp) && (this.a.a != null)) {
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    if ((!this.a.Xp) && (this.a.a != null)) {
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, int paramInt, boolean paramBoolean)
  {
    if ((!this.a.Xp) && (this.a.a != null)) {
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    if (!this.a.Xp)
    {
      if (this.a.a != null) {
        this.a.a.notifyDataSetChanged();
      }
      this.a.Af();
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((!this.a.Xp) && (this.a.a != null)) {
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.b(paramLong1, paramLong2, paramBoolean);
    if (!this.a.Xp)
    {
      if (this.a.a != null) {
        this.a.a.notifyDataSetChanged();
      }
      this.a.Af();
    }
  }
  
  protected void bI(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoMembersListviewAvtivity", 2, "onCloseMemberListActivity --> RelationId = " + paramLong + "mRelationUin = " + this.a.oE);
    }
    if (paramLong == this.a.oE) {
      MultiVideoMembersListviewAvtivity.a(this.a);
    }
    super.bI(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jby
 * JD-Core Version:    0.7.0.1
 */