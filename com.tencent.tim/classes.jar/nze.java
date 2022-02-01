import com.tencent.biz.pubaccount.share.watchword.mvp.RIJWriteWatchWordPresenter.fetchTopicWatchWord.1;
import com.tencent.biz.pubaccount.share.watchword.mvp.RIJWriteWatchWordPresenter.fetchVideoWatchWord.1;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/share/watchword/mvp/RIJWriteWatchWordPresenter;", "Lcom/tencent/biz/pubaccount/share/watchword/mvp/IRIJWriteWatchWordShareContract$IPresenter;", "model", "Lcom/tencent/biz/pubaccount/share/watchword/mvp/IRIJWriteWatchWordShareContract$IModel;", "(Lcom/tencent/biz/pubaccount/share/watchword/mvp/IRIJWriteWatchWordShareContract$IModel;)V", "view", "Lcom/tencent/biz/pubaccount/share/watchword/mvp/IRIJWriteWatchWordShareContract$IView;", "attachView", "", "detachView", "fetchTopicWatchWord", "topicId", "", "url", "title", "fetchVideoWatchWord", "rowkey", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class nze
{
  private final nyy.a jdField_a_of_type_Nyy$a;
  private nyy.b jdField_a_of_type_Nyy$b;
  
  public nze(@NotNull nyy.a parama)
  {
    this.jdField_a_of_type_Nyy$a = parama;
  }
  
  public void L(@NotNull String paramString1, @NotNull String paramString2, @Nullable String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "topicId");
    Intrinsics.checkParameterIsNotNull(paramString2, "url");
    nyy.a locala = this.jdField_a_of_type_Nyy$a;
    if (paramString3 != null) {}
    for (String str = paramString3;; str = "")
    {
      locala.a(paramString1, paramString2, str, (Function3)new RIJWriteWatchWordPresenter.fetchTopicWatchWord.1(this, paramString3, paramString2));
      return;
    }
  }
  
  public void a(@NotNull nyy.b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "view");
    this.jdField_a_of_type_Nyy$b = paramb;
  }
  
  public void detachView()
  {
    this.jdField_a_of_type_Nyy$b = ((nyy.b)null);
  }
  
  public void l(@NotNull String paramString1, @NotNull String paramString2, @Nullable String paramString3, @Nullable String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowkey");
    Intrinsics.checkParameterIsNotNull(paramString2, "url");
    nyy.a locala = this.jdField_a_of_type_Nyy$a;
    if (paramString4 != null) {}
    for (String str = paramString4;; str = "")
    {
      locala.a(paramString1, paramString2, paramString3, str, (Function3)new RIJWriteWatchWordPresenter.fetchVideoWatchWord.1(this, paramString4, paramString2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nze
 * JD-Core Version:    0.7.0.1
 */