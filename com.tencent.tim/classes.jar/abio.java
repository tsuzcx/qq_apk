import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.qphone.base.util.QLog;

class abio
  implements abyv.a
{
  abio(abin paramabin) {}
  
  public void hO(int paramInt)
  {
    QLog.d("sava_ChatPieApolloViewController", 1, "sava_native_log preLoadApolloEngine onSoLoadComplete ret:" + paramInt);
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "sava_native_log preLoadApolloEngine onSoLoadComplete");
      }
      if (abin.a(this.this$0))
      {
        QLog.i("sava_ChatPieApolloViewController", 1, "onSoLoadComplete but AIO destroy!");
        return;
      }
      if (this.this$0.c != null)
      {
        this.this$0.c.preLoadDirector();
        abin.a(this.this$0);
      }
    }
    abyv.b(this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abio
 * JD-Core Version:    0.7.0.1
 */