import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/share/watchword/mvp/IRIJWriteWatchWordShareContract;", "", "IModel", "IPresenter", "IView", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface nyy
{
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/share/watchword/mvp/IRIJWriteWatchWordShareContract$IModel;", "", "failedToast", "", "getFailedToast", "()Ljava/lang/String;", "successToast", "getSuccessToast", "copyToClipboard", "", "watchWord", "url", "title", "isOpen", "", "type", "", "fetchTopicWatchWord", "topicId", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "fetchVideoWatchWord", "rowkey", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static abstract interface a
  {
    public abstract void a(@NotNull String paramString1, @NotNull String paramString2, @Nullable String paramString3, @NotNull String paramString4, @Nullable Function3<? super String, ? super String, ? super Boolean, Unit> paramFunction3);
    
    public abstract void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @Nullable Function3<? super String, ? super String, ? super Boolean, Unit> paramFunction3);
    
    public abstract void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, boolean paramBoolean, int paramInt);
    
    @NotNull
    public abstract String kY();
    
    @NotNull
    public abstract String kZ();
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/share/watchword/mvp/IRIJWriteWatchWordShareContract$IView;", "", "showFailedToast", "", "wording", "", "showSuccessToast", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static abstract interface b
  {
    public abstract void showFailedToast(@NotNull String paramString);
    
    public abstract void showSuccessToast(@NotNull String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nyy
 * JD-Core Version:    0.7.0.1
 */