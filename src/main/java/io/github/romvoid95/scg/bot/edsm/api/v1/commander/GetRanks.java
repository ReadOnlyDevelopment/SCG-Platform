
package io.github.romvoid95.scg.bot.edsm.api.v1.commander;

import io.github.romvoid95.scg.bot.edsm.api.EdsmResponse;
import io.github.romvoid95.scg.bot.edsm.api.v1.commander.modal.Progress;
import io.github.romvoid95.scg.bot.edsm.api.v1.commander.modal.Ranks;
import io.github.romvoid95.scg.bot.edsm.api.v1.commander.modal.RanksVerbose;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetRanks extends EdsmResponse
{
    private Ranks        ranks;
    private Progress     progress;
    private RanksVerbose ranksVerbose;
}
