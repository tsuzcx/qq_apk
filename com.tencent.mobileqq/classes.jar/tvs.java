import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/SuperMaskStepUtil;", "", "()V", "dealStepResult", "", "result", "step", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/SuperMaskStep;", "doSuperMaskStep", "tag", "", "steps", "", "(Ljava/lang/String;[Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/SuperMaskStep;)Z", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tvs
{
  public static final tvs a = new tvs();
  
  public final boolean a(@NotNull String paramString, @NotNull tvc... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "tag");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "steps");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      tvc localtvc = paramVarArgs[i];
      localtvc.a(paramString);
      if (!localtvc.a()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final boolean a(boolean paramBoolean, @NotNull tvc paramtvc)
  {
    Intrinsics.checkParameterIsNotNull(paramtvc, "step");
    StringBuilder localStringBuilder = new StringBuilder().append(paramtvc.a() + " : ").append(paramtvc.getClass().getSimpleName() + " : ");
    if (paramtvc.b() != null) {
      localStringBuilder.append(paramtvc.b() + " : ");
    }
    if (!paramBoolean) {
      localStringBuilder.append("check fail");
    }
    for (;;)
    {
      twp.a("ReadInJoySuperMaskAd", localStringBuilder.toString());
      return paramBoolean;
      localStringBuilder.append("check success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvs
 * JD-Core Version:    0.7.0.1
 */