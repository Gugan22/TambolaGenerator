package in.gugan.tambolagenerator.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ApplicationExceptionHandler {
//
//    @ExceptionHandler({SystemException.class})
//    public ResponseEntity<ErrorResponse> systemExceptionHandler(SystemException e){
//        e.printStackTrace();
//        return ResponseEntity.status(e.getStatus())
//                .body(
//                        ErrorResponse.builder()
//                                .status(e.getStatus())
//                                .cause(e.getErrorCause())
//                                .message(e.getMessage())
//                                .build()
//                );
//    }
//
//    @ExceptionHandler({Exception.class, RuntimeException.class})
//    public ResponseEntity<ErrorResponse> internalExceptionHandler(Exception e){
//        return ResponseEntity.internalServerError()
//                .body(
//                        ErrorResponse.builder()
//                                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                                .cause(e.getMessage())
//                                .message("Oops! Something went wrong.")
//                                .build()
//                );
//    }

}
