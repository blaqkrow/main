package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.ChangeThemeCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.ClearLogCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteAllPhotosCommand;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DeletePhotoCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EmailCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.ExportCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.HistoryCommand;
import seedu.address.logic.commands.ImportCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.QrCallCommand;
import seedu.address.logic.commands.QrSaveContactCommand;
import seedu.address.logic.commands.QrSmsCommand;
import seedu.address.logic.commands.RedoCommand;
import seedu.address.logic.commands.RemoveTagCommand;
import seedu.address.logic.commands.SelectCommand;
import seedu.address.logic.commands.SortCommand;
import seedu.address.logic.commands.TagCommand;
import seedu.address.logic.commands.UndoCommand;
import seedu.address.logic.commands.UploadPhotoCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
        case AddCommand.COMMAND_ALIAS:
            return new AddCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
        case EditCommand.COMMAND_ALIAS:
            return new EditCommandParser().parse(arguments);

        case SelectCommand.COMMAND_WORD:
        case SelectCommand.COMMAND_ALIAS:
            return new SelectCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
        case DeleteCommand.COMMAND_ALIAS:
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
        case ClearCommand.COMMAND_ALIAS:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
        case FindCommand.COMMAND_ALIAS:
            return new FindCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
        case ListCommand.COMMAND_ALIAS:
            return new ListCommand();

        case HistoryCommand.COMMAND_WORD:
        case HistoryCommand.COMMAND_ALIAS:
            return new HistoryCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case UndoCommand.COMMAND_WORD:
        case UndoCommand.COMMAND_ALIAS:
            return new UndoCommand();

        case RedoCommand.COMMAND_WORD:
        case RedoCommand.COMMAND_ALIAS:
            return new RedoCommand();

        case TagCommand.COMMAND_WORD:
        case TagCommand.COMMAND_ALIAS:
            return new TagCommandParser().parse(arguments);

        case SortCommand.COMMAND_WORD:
        case SortCommand.COMMAND_ALIAS:
            return new SortCommand();

        case RemoveTagCommand.COMMAND_WORD:
        case RemoveTagCommand.COMMAND_ALIAS:
            return new RemoveTagCommandParser().parse(arguments);

        case ImportCommand.COMMAND_WORD:
        case ImportCommand.COMMAND_ALIAS:
            return new ImportCommandParser().parse(arguments);

        case ExportCommand.COMMAND_WORD:
        case ExportCommand.COMMAND_ALIAS:
            return new ExportCommand();

        case EmailCommand.COMMAND_WORD:
        case EmailCommand.COMMAND_ALIAS:
            return new EmailCommandParser().parse(arguments);

        case UploadPhotoCommand.COMMAND_WORD:
        case UploadPhotoCommand.COMMAND_ALIAS:
            return new UploadPhotoCommandParser().parse(arguments);

        case ClearLogCommand.COMMAND_WORD:
        case ClearLogCommand.COMMAND_ALIAS:
            return new ClearLogCommand();

        case QrCallCommand.COMMAND_WORD:
        case QrCallCommand.COMMAND_ALIAS:
            return new QrCallCommandParser().parse(arguments);

        case QrSmsCommand.COMMAND_WORD:
        case QrSmsCommand.COMMAND_ALIAS:
            return new QrSmsCommandParser().parse(arguments);

        case QrSaveContactCommand.COMMAND_WORD:
        case QrSaveContactCommand.COMMAND_ALIAS:
            return new QrSaveContactCommandParser().parse(arguments);

        case ChangeThemeCommand.COMMAND_WORD:
        case ChangeThemeCommand.COMMAND_ALIAS:
            return new ChangeThemeCommandParser().parse(arguments);

        case DeletePhotoCommand.COMMAND_WORD:
        case DeletePhotoCommand.COMMAND_ALIAS:
            return new DeletePhotoCommandParser().parse(arguments);

        case DeleteAllPhotosCommand.COMMAND_WORD:
        case DeleteAllPhotosCommand.COMMAND_ALIAS:
            return new DeleteAllPhotosCommand();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
