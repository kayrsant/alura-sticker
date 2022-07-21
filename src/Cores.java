import com.diogonunes.jcolor.AnsiFormat;

import static com.diogonunes.jcolor.Attribute.*;

public class Cores {

  AnsiFormat negrito = new AnsiFormat(BOLD());
  AnsiFormat backYellowTextWhiteB = new AnsiFormat(YELLOW_BACK(), WHITE_TEXT(), BOLD());
  AnsiFormat backYellowTextWhite = new AnsiFormat(YELLOW_BACK(), YELLOW_TEXT());
  AnsiFormat backBlueTextWhiteB = new AnsiFormat(BLUE_BACK(), WHITE_TEXT(), BOLD());
  AnsiFormat backBlueTextWhite = new AnsiFormat(BLUE_BACK(), WHITE_TEXT());
  AnsiFormat backGreenTextBlackB = new AnsiFormat(GREEN_BACK(), BLACK_TEXT(), BOLD());
  AnsiFormat backGreenTextBlack = new AnsiFormat(GREEN_BACK(), BLACK_TEXT());
  AnsiFormat backCyanTextWhiteB = new AnsiFormat(CYAN_BACK(), WHITE_TEXT(), BOLD());
  AnsiFormat backCyanTextWhite = new AnsiFormat(CYAN_BACK(), WHITE_TEXT());
  AnsiFormat backRedTextWhiteB = new AnsiFormat(RED_BACK(), WHITE_TEXT(), BOLD());
  AnsiFormat backRedTextWhite = new AnsiFormat(RED_BACK(), WHITE_TEXT());
}