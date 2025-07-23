package com.google.mediapipe.examples.objectdetection;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 G2\u00020\u0001:\u0003GHIBK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000eJ\u0006\u0010*\u001a\u00020+J\u0018\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0007J\u0010\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\u00020+2\u0006\u00106\u001a\u000207J\u0018\u00108\u001a\u0004\u0018\u0001022\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u000200J\u0006\u0010<\u001a\u00020=J\u0014\u0010>\u001a\u00020+2\n\u0010?\u001a\u00060@j\u0002`AH\u0002J\u0018\u0010B\u001a\u00020+2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020.H\u0002J\u0006\u0010F\u001a\u00020+R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)\u00a8\u0006J"}, d2 = {"Lcom/google/mediapipe/examples/objectdetection/ObjectDetectorHelper;", "", "threshold", "", "maxResults", "", "currentDelegate", "currentModel", "runningMode", "Lcom/google/mediapipe/tasks/vision/core/RunningMode;", "context", "Landroid/content/Context;", "objectDetectorListener", "Lcom/google/mediapipe/examples/objectdetection/ObjectDetectorHelper$DetectorListener;", "(FIIILcom/google/mediapipe/tasks/vision/core/RunningMode;Landroid/content/Context;Lcom/google/mediapipe/examples/objectdetection/ObjectDetectorHelper$DetectorListener;)V", "getContext", "()Landroid/content/Context;", "getCurrentDelegate", "()I", "setCurrentDelegate", "(I)V", "getCurrentModel", "setCurrentModel", "imageProcessingOptions", "Lcom/google/mediapipe/tasks/vision/core/ImageProcessingOptions;", "imageRotation", "getMaxResults", "setMaxResults", "objectDetector", "Lcom/google/mediapipe/tasks/vision/objectdetector/ObjectDetector;", "getObjectDetectorListener", "()Lcom/google/mediapipe/examples/objectdetection/ObjectDetectorHelper$DetectorListener;", "setObjectDetectorListener", "(Lcom/google/mediapipe/examples/objectdetection/ObjectDetectorHelper$DetectorListener;)V", "getRunningMode", "()Lcom/google/mediapipe/tasks/vision/core/RunningMode;", "setRunningMode", "(Lcom/google/mediapipe/tasks/vision/core/RunningMode;)V", "getThreshold", "()F", "setThreshold", "(F)V", "clearObjectDetector", "", "detectAsync", "mpImage", "Lcom/google/mediapipe/framework/image/MPImage;", "frameTime", "", "detectImage", "Lcom/google/mediapipe/examples/objectdetection/ObjectDetectorHelper$ResultBundle;", "image", "Landroid/graphics/Bitmap;", "detectLivestreamFrame", "imageProxy", "Landroidx/camera/core/ImageProxy;", "detectVideoFile", "videoUri", "Landroid/net/Uri;", "inferenceIntervalMs", "isClosed", "", "returnLivestreamError", "error", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "returnLivestreamResult", "result", "Lcom/google/mediapipe/tasks/vision/objectdetector/ObjectDetectorResult;", "input", "setupObjectDetector", "Companion", "DetectorListener", "ResultBundle", "app_debug"})
public final class ObjectDetectorHelper {
    private float threshold;
    private int maxResults;
    private int currentDelegate;
    private int currentModel;
    @org.jetbrains.annotations.NotNull()
    private com.google.mediapipe.tasks.vision.core.RunningMode runningMode;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable()
    private com.google.mediapipe.examples.objectdetection.ObjectDetectorHelper.DetectorListener objectDetectorListener;
    @org.jetbrains.annotations.Nullable()
    private com.google.mediapipe.tasks.vision.objectdetector.ObjectDetector objectDetector;
    private int imageRotation = 0;
    private com.google.mediapipe.tasks.vision.core.ImageProcessingOptions imageProcessingOptions;
    public static final int DELEGATE_CPU = 0;
    public static final int DELEGATE_GPU = 1;
    public static final int MODEL_TANKS = 0;
    public static final int MODEL_EFFICIENTDETV2 = 1;
    public static final int MAX_RESULTS_DEFAULT = 3;
    public static final float THRESHOLD_DEFAULT = 0.5F;
    public static final int OTHER_ERROR = 0;
    public static final int GPU_ERROR = 1;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "ObjectDetectorHelper";
    @org.jetbrains.annotations.NotNull()
    public static final com.google.mediapipe.examples.objectdetection.ObjectDetectorHelper.Companion Companion = null;
    
    public ObjectDetectorHelper(float threshold, int maxResults, int currentDelegate, int currentModel, @org.jetbrains.annotations.NotNull()
    com.google.mediapipe.tasks.vision.core.RunningMode runningMode, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    com.google.mediapipe.examples.objectdetection.ObjectDetectorHelper.DetectorListener objectDetectorListener) {
        super();
    }
    
    public final float getThreshold() {
        return 0.0F;
    }
    
    public final void setThreshold(float p0) {
    }
    
    public final int getMaxResults() {
        return 0;
    }
    
    public final void setMaxResults(int p0) {
    }
    
    public final int getCurrentDelegate() {
        return 0;
    }
    
    public final void setCurrentDelegate(int p0) {
    }
    
    public final int getCurrentModel() {
        return 0;
    }
    
    public final void setCurrentModel(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.mediapipe.tasks.vision.core.RunningMode getRunningMode() {
        return null;
    }
    
    public final void setRunningMode(@org.jetbrains.annotations.NotNull()
    com.google.mediapipe.tasks.vision.core.RunningMode p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.mediapipe.examples.objectdetection.ObjectDetectorHelper.DetectorListener getObjectDetectorListener() {
        return null;
    }
    
    public final void setObjectDetectorListener(@org.jetbrains.annotations.Nullable()
    com.google.mediapipe.examples.objectdetection.ObjectDetectorHelper.DetectorListener p0) {
    }
    
    public final void clearObjectDetector() {
    }
    
    public final void setupObjectDetector() {
    }
    
    public final boolean isClosed() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.mediapipe.examples.objectdetection.ObjectDetectorHelper.ResultBundle detectVideoFile(@org.jetbrains.annotations.NotNull()
    android.net.Uri videoUri, long inferenceIntervalMs) {
        return null;
    }
    
    public final void detectLivestreamFrame(@org.jetbrains.annotations.NotNull()
    androidx.camera.core.ImageProxy imageProxy) {
    }
    
    @androidx.annotation.VisibleForTesting()
    public final void detectAsync(@org.jetbrains.annotations.NotNull()
    com.google.mediapipe.framework.image.MPImage mpImage, long frameTime) {
    }
    
    private final void returnLivestreamResult(com.google.mediapipe.tasks.vision.objectdetector.ObjectDetectorResult result, com.google.mediapipe.framework.image.MPImage input) {
    }
    
    private final void returnLivestreamError(java.lang.RuntimeException error) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.mediapipe.examples.objectdetection.ObjectDetectorHelper.ResultBundle detectImage(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap image) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/google/mediapipe/examples/objectdetection/ObjectDetectorHelper$Companion;", "", "()V", "DELEGATE_CPU", "", "DELEGATE_GPU", "GPU_ERROR", "MAX_RESULTS_DEFAULT", "MODEL_EFFICIENTDETV2", "MODEL_TANKS", "OTHER_ERROR", "TAG", "", "THRESHOLD_DEFAULT", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/google/mediapipe/examples/objectdetection/ObjectDetectorHelper$DetectorListener;", "", "onError", "", "error", "", "errorCode", "", "onResults", "resultBundle", "Lcom/google/mediapipe/examples/objectdetection/ObjectDetectorHelper$ResultBundle;", "app_debug"})
    public static abstract interface DetectorListener {
        
        public abstract void onError(@org.jetbrains.annotations.NotNull()
        java.lang.String error, int errorCode);
        
        public abstract void onResults(@org.jetbrains.annotations.NotNull()
        com.google.mediapipe.examples.objectdetection.ObjectDetectorHelper.ResultBundle resultBundle);
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
        public static final class DefaultImpls {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u00a2\u0006\u0002\u0010\u000bJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0017\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0018\u001a\u00020\bH\u00c6\u0003JA\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\bH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006 "}, d2 = {"Lcom/google/mediapipe/examples/objectdetection/ObjectDetectorHelper$ResultBundle;", "", "results", "", "Lcom/google/mediapipe/tasks/vision/objectdetector/ObjectDetectorResult;", "inferenceTime", "", "inputImageHeight", "", "inputImageWidth", "inputImageRotation", "(Ljava/util/List;JIII)V", "getInferenceTime", "()J", "getInputImageHeight", "()I", "getInputImageRotation", "getInputImageWidth", "getResults", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
    public static final class ResultBundle {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.google.mediapipe.tasks.vision.objectdetector.ObjectDetectorResult> results = null;
        private final long inferenceTime = 0L;
        private final int inputImageHeight = 0;
        private final int inputImageWidth = 0;
        private final int inputImageRotation = 0;
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.google.mediapipe.tasks.vision.objectdetector.ObjectDetectorResult> component1() {
            return null;
        }
        
        public final long component2() {
            return 0L;
        }
        
        public final int component3() {
            return 0;
        }
        
        public final int component4() {
            return 0;
        }
        
        public final int component5() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.google.mediapipe.examples.objectdetection.ObjectDetectorHelper.ResultBundle copy(@org.jetbrains.annotations.NotNull()
        java.util.List<? extends com.google.mediapipe.tasks.vision.objectdetector.ObjectDetectorResult> results, long inferenceTime, int inputImageHeight, int inputImageWidth, int inputImageRotation) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
        
        public ResultBundle(@org.jetbrains.annotations.NotNull()
        java.util.List<? extends com.google.mediapipe.tasks.vision.objectdetector.ObjectDetectorResult> results, long inferenceTime, int inputImageHeight, int inputImageWidth, int inputImageRotation) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.google.mediapipe.tasks.vision.objectdetector.ObjectDetectorResult> getResults() {
            return null;
        }
        
        public final long getInferenceTime() {
            return 0L;
        }
        
        public final int getInputImageHeight() {
            return 0;
        }
        
        public final int getInputImageWidth() {
            return 0;
        }
        
        public final int getInputImageRotation() {
            return 0;
        }
    }
}