import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class pry
  implements ppv.b<pyx, qai>
{
  pry(prw paramprw) {}
  
  public void a(@NonNull pyx parampyx, @Nullable qai paramqai, @NonNull ErrorMessage paramErrorMessage)
  {
    ram.d("AddressDataProvider", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramqai != null))
    {
      ram.b("AddressDataProvider", "requestAddress onCmdRespond success : %s .", paramqai.toString());
      this.a.data = new prw.a(paramqai.awy, paramqai.awz, paramqai.awA, paramqai.awB, paramqai.awC, parampyx.blt, parampyx.blu);
      this.a.co("country", paramqai.awy);
      this.a.co("province", paramqai.awz);
      this.a.co("city", paramqai.awA);
      this.a.co("district", paramqai.awB);
      this.a.co("street", paramqai.awC);
      this.a.bn("longitude", parampyx.blt);
      this.a.bn("latitude", parampyx.blu);
      this.a.J("time", System.currentTimeMillis());
      this.a.k(true, this.a.data);
    }
    for (;;)
    {
      this.a.gV = false;
      return;
      ram.w("AddressDataProvider", "requestAddress onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, parampyx });
      this.a.k(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pry
 * JD-Core Version:    0.7.0.1
 */