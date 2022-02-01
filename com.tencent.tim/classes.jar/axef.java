import android.view.View;
import android.view.View.OnClickListener;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class axef
  implements View.OnClickListener
{
  axef(axec paramaxec) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    axec.a(this.a, true);
    Set localSet = axec.a(this.a).H();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, selectedItems = " + localSet);
    Object localObject = axip.a();
    ((axip)localObject).eLA();
    int i = 0;
    while (i < axec.a(this.a).size()) {
      if (!localSet.contains(Integer.valueOf(i)))
      {
        i += 1;
      }
      else
      {
        if (((axdj)axec.a(this.a).get(i)).c != null)
        {
          ((axip)localObject).acY(((axdj)axec.a(this.a).get(i)).c.id);
          ((axip)localObject).acX("none");
          ((axip)localObject).setTextColor("none");
        }
        for (;;)
        {
          axim.a().eLq();
          break;
          if (!((axdj)axec.a(this.a).get(i)).text.equals(""))
          {
            ((axip)localObject).acY("none");
            ((axip)localObject).acX(((axdl.a)axdl.colorList.get(axdl.tO[(i % axdl.tO.length)])).textColor);
            ((axip)localObject).setTextColor(((axdj)axec.a(this.a).get(i)).text);
          }
          else
          {
            ((axip)localObject).acY("none");
            ((axip)localObject).acX("none");
            ((axip)localObject).setTextColor("none");
          }
        }
      }
    }
    axec.a(this.a).stop(false);
    axfq localaxfq = axec.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, pngDirs = " + localaxfq.FD + ", texts = " + localaxfq.FE);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    i = j;
    if (i < localaxfq.FD.size())
    {
      Integer localInteger = (Integer)localaxfq.FG.get(i);
      if (localSet.contains(localInteger))
      {
        if ((i != 0) || (axec.a(this.a) == null)) {
          break label599;
        }
        localArrayList1.add(axec.a(this.a).cUd);
        localArrayList2.add(axec.a(this.a).text);
        localArrayList3.add(axec.a(this.a).cUf);
      }
      for (;;)
      {
        String str = axec.a(this.a, localInteger.intValue());
        StringBuilder localStringBuilder = new StringBuilder().append("gif^");
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localObject = (String)localObject;
        localArrayList4.add(localObject);
        axiy.i("AEGIFChunkPreviewFragment", "save gif, index=" + i + ", widgetInfo=" + (String)localObject + ", originIndex=" + localInteger);
        i += 1;
        break;
        label599:
        localArrayList1.add(localaxfq.FD.get(i));
        localArrayList2.add(localaxfq.FE.get(i));
        localArrayList3.add(localaxfq.FF.get(i));
      }
    }
    axec.a(this.a, localArrayList1, localArrayList2, localArrayList3, localArrayList4);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axef
 * JD-Core Version:    0.7.0.1
 */