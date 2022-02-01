import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xc6d.oidb_cmd0xc6d.ModuleInfo;
import tencent.im.oidb.cmd0xc6d.oidb_cmd0xc6d.TextCardInfo;

public class nks
  extends lce
{
  public nks(FastWebActivity paramFastWebActivity) {}
  
  public void b(ArrayList<String> paramArrayList, List<oidb_cmd0xc6d.ModuleInfo> paramList, List<oidb_cmd0xc6d.TextCardInfo> paramList1)
  {
    Object localObject = nnc.e(23, paramArrayList);
    if (FastWebActivity.a(this.this$0) != null) {}
    for (paramArrayList = FastWebActivity.a(this.this$0).innerUniqueID;; paramArrayList = "")
    {
      if ((TextUtils.isEmpty(paramArrayList)) || (FastWebActivity.a(this.this$0) == null)) {
        return;
      }
      int i = 0;
      while (i < ((List)localObject).size())
      {
        BaseData localBaseData = (BaseData)((List)localObject).get(i);
        if ((localBaseData instanceof ProteusItemData)) {
          nnc.a(FastWebActivity.a(this.this$0), (ProteusItemData)localBaseData, 3, this.this$0.ax);
        }
        nnn.b(FastWebActivity.a(this.this$0), localBaseData, FastWebActivity.a(this.this$0));
        i += 1;
      }
      localObject = lbz.a().a();
      if (localObject != null) {
        ((lhu)localObject).h(paramArrayList, FastWebActivity.a(this.this$0));
      }
      if (paramList != null) {
        nmp.a(FastWebActivity.a(this.this$0), FastWebActivity.a(this.this$0), FastWebActivity.a(this.this$0), paramList, FastWebActivity.a(this.this$0), this.this$0.ax);
      }
      if (paramList1 != null) {
        nmp.b(FastWebActivity.a(this.this$0), FastWebActivity.a(this.this$0), FastWebActivity.a(this.this$0), paramList1, FastWebActivity.a(this.this$0), this.this$0.ax);
      }
      if (FastWebActivity.a(this.this$0) != null) {
        FastWebActivity.a(this.this$0).notifyDataSetChanged();
      }
      QLog.d(FastWebActivity.a(this.this$0), 1, "m0xc6dRespObserver,onHandle0xc6dResp");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nks
 * JD-Core Version:    0.7.0.1
 */