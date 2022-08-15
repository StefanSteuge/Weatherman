package bot;

import lombok.SneakyThrows;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import service.impl.WeatherServiceImpl;

public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        var cityName = update.getMessage().getText();
        var service = new WeatherServiceImpl();
       sendMsg(update.getMessage().getChatId().toString(), service.getByCityName(cityName).toString());
    }

    @SneakyThrows
    public synchronized void sendMsg(String chatId, String msg) {
        var sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(msg);
        execute(sendMessage);
    }

    @Override
    public String getBotUsername() {
        return "WeatherFakeBot";
    }

    @Override
    public String getBotToken() {
        return "5452969749:AAEcm5Pp5EwfuEqnx7Muf30m6pVGLterxbs";
    }
}
