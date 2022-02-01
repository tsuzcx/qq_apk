import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher.a;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher.b;

public class njz
  implements ItemShowDispatcher.b
{
  public njz(FastWebActivity paramFastWebActivity, int paramInt, BaseData paramBaseData) {}
  
  public BaseData a()
  {
    return this.d;
  }
  
  public void aED()
  {
    ItemShowDispatcher.a locala = FastWebActivity.a(this.this$0).a(this.aKe);
    if (locala != null)
    {
      nns.b(this.this$0.app, (AdData)this.d, locala.kD, locala.exposureTime);
      return;
    }
    nns.d(this.this$0.app, (AdData)this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     njz
 * JD-Core Version:    0.7.0.1
 */