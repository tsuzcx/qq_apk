import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView.a;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;
import java.util.Map;

public class aylq
  implements ayjv.a
{
  public aylq(DoodleEditView paramDoodleEditView) {}
  
  public void a(ayoo.a parama, int paramInt1, int paramInt2)
  {
    if (parama == null) {}
    label4:
    Object localObject;
    label192:
    do
    {
      do
      {
        break label4;
        do
        {
          return;
        } while ((this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.aQQ()) || (parama.dAg));
        if (!parama.aQK()) {
          this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parama, 0);
        }
        if (!this.this$0.aQN()) {
          if ((parama instanceof ayjw.c)) {
            a(parama, paramInt1, paramInt2, 0.0F, 0.0F);
          }
        }
        for (;;)
        {
          if (!(parama instanceof ayjt.a)) {
            break label192;
          }
          localObject = (ayjt.a)parama;
          if (((ayjt.a)localObject).b == null) {
            break;
          }
          ((ayjt.a)localObject).b.a(parama, paramInt1, paramInt2);
          return;
          if ((((parama instanceof ayjn.b)) || ((parama instanceof ayjn.a))) && (DoodleEditView.a(this.this$0) != null))
          {
            DoodleEditView.a(this.this$0).a(parama);
            continue;
            if ((((parama instanceof ayjn.b)) || ((parama instanceof ayjn.a)) || ((parama instanceof ayjw.c))) && (DoodleEditView.a(this.this$0) != null)) {
              DoodleEditView.a(this.this$0).a(parama);
            }
          }
        }
      } while (!(parama instanceof aykb.b));
      localObject = (aykb.b)parama;
    } while (((aykb.b)localObject).b == null);
    ((aykb.b)localObject).b.a(parama, paramInt1, paramInt2);
  }
  
  public void a(ayoo.a parama, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if ((parama instanceof ayjw.c))
    {
      parama = ((ayjw.c)parama).c;
      if (parama != null)
      {
        int i = paramInt2;
        if (!parama.aPK())
        {
          i = paramInt2;
          if (paramInt2 == 0) {
            i = 3;
          }
        }
        switch (i)
        {
        }
      }
    }
    do
    {
      do
      {
        do
        {
          Object localObject;
          do
          {
            do
            {
              return;
              parama.eOT();
              parama.a(-1, this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a, false, 3000, 500, null);
              return;
              parama.cz(paramInt1, true);
              paramInt2 = paramInt1;
              if (paramInt1 == -1) {
                paramInt2 = 0;
              }
              localObject = this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
              if (DoodleEditView.a(this.this$0) == 1) {
                bool1 = true;
              }
              ((DoodleLayout)localObject).a(parama, paramInt2, 1, bool1);
              return;
              paramInt2 = paramInt1;
              if (paramInt1 == -1) {
                paramInt2 = 0;
              }
              parama.cz(paramInt2, true);
              localObject = this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
              if (DoodleEditView.a(this.this$0) == 1) {}
              for (bool1 = bool2;; bool1 = false)
              {
                ((DoodleLayout)localObject).a(parama, paramInt2, 2, bool1);
                return;
              }
              if (!(parama instanceof ayjn.b)) {
                break;
              }
              localObject = (ayjn.b)parama;
            } while (!((ayjn.b)localObject).dzB);
            ram.d("DoodleEditView", "click the item:" + parama);
          } while (((ayjn.b)localObject).dzC);
          this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.d((ayjn.b)localObject);
          return;
          if (!(parama instanceof ayjt.a)) {
            break;
          }
          this.this$0.tK(true);
          this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b((ayjt.a)parama, paramFloat1, paramFloat2);
        } while (((ayjt.a)parama).b == null);
        ((ayjt.a)parama).b.a(parama, paramInt1, paramInt2, paramFloat1, paramFloat2);
        return;
      } while (!(parama instanceof aykb.b));
      this.this$0.tK(true);
      this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b((aykb.b)parama, paramFloat1, paramFloat2);
    } while (((aykb.b)parama).b == null);
    ((aykb.b)parama).b.a(parama, paramInt1, paramInt2, paramFloat1, paramFloat2);
  }
  
  public void b(ayoo.a parama, int paramInt1, int paramInt2)
  {
    ram.d("DoodleEditView", "onClickBottomLeftBtn click the item:" + parama);
    if (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.aQQ()) {}
    do
    {
      do
      {
        return;
      } while (parama == null);
      if (DoodleEditView.a(this.this$0) != null) {
        DoodleEditView.a(this.this$0).eNB();
      }
      if (parama.aQK())
      {
        this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parama, 1);
        if (parama.isAnchor) {
          this.this$0.j(parama);
        }
      }
    } while (parama.isAnchor);
    this.this$0.e(parama);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
    }
  }
  
  public void h(ayoo.a parama)
  {
    if ((parama instanceof ayjt.a))
    {
      this.this$0.tK(true);
      this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((ayjt.a)parama);
      if (((ayjt.a)parama).b != null) {
        ((ayjt.a)parama).b.h(parama);
      }
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parama, 0);
      this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.eNv();
      return;
      if ((parama instanceof aykb.b))
      {
        this.this$0.tK(true);
        this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b((aykb.b)parama);
        if (((aykb.b)parama).b != null) {
          ((aykb.b)parama).b.h(parama);
        }
      }
      else
      {
        if ((parama instanceof ayjn.b))
        {
          ayjn.b localb = (ayjn.b)parama;
          if (localb.dzB)
          {
            if ((this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Lb())) {}
            for (localObject = this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();; localObject = this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a())
            {
              ((ayjn)localObject).oK.remove(localb);
              this.this$0.jdField_a_of_type_Ayjv.btS();
              break;
            }
          }
          if ((localb.eGY == 1) && ((this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Lb()))) {}
          for (Object localObject = this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();; localObject = this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a())
          {
            localObject = (List)((ayjn)localObject).gg.get(localb.category);
            if (localObject == null) {
              break;
            }
            ((List)localObject).remove(localb.name);
            break;
          }
        }
        if ((parama instanceof ayjw.c))
        {
          this.this$0.jdField_a_of_type_Ayjv.btS();
          if (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
            this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.eSC();
          }
        }
        else
        {
          this.this$0.jdField_a_of_type_Ayjv.btS();
        }
      }
    }
  }
  
  public void i(ayoo.a parama)
  {
    if (parama == null) {}
    label4:
    Object localObject;
    do
    {
      do
      {
        do
        {
          break label4;
          do
          {
            return;
          } while (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.aQQ());
          if (!(parama instanceof ayjt.a)) {
            break;
          }
          localObject = (ayjt.a)parama;
        } while (((ayjt.a)localObject).b == null);
        ((ayjt.a)localObject).b.i(parama);
        return;
      } while (!(parama instanceof aykb.b));
      localObject = (aykb.b)parama;
    } while (((aykb.b)localObject).b == null);
    ((aykb.b)localObject).b.i(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aylq
 * JD-Core Version:    0.7.0.1
 */