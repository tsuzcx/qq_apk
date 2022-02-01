package com.tencent.qapmsdk.base.listener;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/listener/ListenerManager;", "", "()V", "batteryReportListener", "Lcom/tencent/qapmsdk/base/listener/IBatteryReportListener;", "inspectorListener", "Lcom/tencent/qapmsdk/base/listener/IInspectorListener;", "memoryCellingListener", "Lcom/tencent/qapmsdk/base/listener/IMemoryCellingListener;", "monitorListener", "Lcom/tencent/qapmsdk/base/listener/IMonitorListener;", "webViewBreadCrumbListener", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qapmsdk/base/listener/IWebViewBreadCrumbListener;", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class ListenerManager
{
  public static final ListenerManager INSTANCE = new ListenerManager();
  @JvmField
  @Nullable
  public static IBatteryReportListener batteryReportListener;
  @JvmField
  @Nullable
  public static IInspectorListener inspectorListener;
  @JvmField
  @Nullable
  public static IMemoryCellingListener memoryCellingListener;
  @JvmField
  @Nullable
  public static IMonitorListener monitorListener;
  @JvmField
  @Nullable
  public static WeakReference<IWebViewBreadCrumbListener> webViewBreadCrumbListener;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.listener.ListenerManager
 * JD-Core Version:    0.7.0.1
 */