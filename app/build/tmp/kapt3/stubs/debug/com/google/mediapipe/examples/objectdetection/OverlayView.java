package com.google.mediapipe.examples.objectdetection;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0002J&\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\fJ\u000e\u0010 \u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/google/mediapipe/examples/objectdetection/OverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bounds", "Landroid/graphics/Rect;", "boxPaint", "Landroid/graphics/Paint;", "outputHeight", "", "outputRotate", "outputWidth", "results", "Lcom/google/mediapipe/tasks/vision/objectdetector/ObjectDetectorResult;", "runningMode", "Lcom/google/mediapipe/tasks/vision/core/RunningMode;", "scaleFactor", "", "textBackgroundPaint", "textPaint", "clear", "", "draw", "canvas", "Landroid/graphics/Canvas;", "initPaints", "setResults", "detectionResults", "imageRotation", "setRunningMode", "Companion", "app_debug"})
public final class OverlayView extends android.view.View {
    @org.jetbrains.annotations.Nullable()
    private com.google.mediapipe.tasks.vision.objectdetector.ObjectDetectorResult results;
    @org.jetbrains.annotations.NotNull()
    private android.graphics.Paint boxPaint;
    @org.jetbrains.annotations.NotNull()
    private android.graphics.Paint textBackgroundPaint;
    @org.jetbrains.annotations.NotNull()
    private android.graphics.Paint textPaint;
    private float scaleFactor = 1.0F;
    @org.jetbrains.annotations.NotNull()
    private android.graphics.Rect bounds;
    private int outputWidth = 0;
    private int outputHeight = 0;
    private int outputRotate = 0;
    @org.jetbrains.annotations.NotNull()
    private com.google.mediapipe.tasks.vision.core.RunningMode runningMode = com.google.mediapipe.tasks.vision.core.RunningMode.IMAGE;
    private static final int BOUNDING_RECT_TEXT_PADDING = 8;
    @org.jetbrains.annotations.NotNull()
    public static final com.google.mediapipe.examples.objectdetection.OverlayView.Companion Companion = null;
    
    public OverlayView(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public final void clear() {
    }
    
    public final void setRunningMode(@org.jetbrains.annotations.NotNull()
    com.google.mediapipe.tasks.vision.core.RunningMode runningMode) {
    }
    
    private final void initPaints() {
    }
    
    @java.lang.Override()
    public void draw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    public final void setResults(@org.jetbrains.annotations.NotNull()
    com.google.mediapipe.tasks.vision.objectdetector.ObjectDetectorResult detectionResults, int outputHeight, int outputWidth, int imageRotation) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/google/mediapipe/examples/objectdetection/OverlayView$Companion;", "", "()V", "BOUNDING_RECT_TEXT_PADDING", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}